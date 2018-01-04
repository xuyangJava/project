package com.siping.java8.Lambda.应对不断变化的需求.Lambda和方法引用实战;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.After;
import org.junit.Test;

import com.siping.java8.Lambda.应对不断变化的需求.Apple;

/**
 * 方法引用实战
 * 用不同的排序策略给Apple列表排序
 * @date 2018年1月4日 上午9:48:22
 * @author yangxu
 * @version 1.0
 */
public class Demo1 {

    List<Apple> inventory = Arrays.asList(new Apple("red", 120), new Apple("green", 119));
    @After
    public void printList() {
        for (Apple apple : inventory) {
            System.out.println(apple.getColor() + " : " + apple.getWeight());
        }
    }
    
    // 1.传递代码
    @Test
    public void test1() {
        inventory.sort(new AppleComparator());
    }
    
    @Test
    //2.使用匿名类
    public void test2() {
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight() - a2.getWeight();
            }
        });
    }
    
    @Test
    // 3.使用 Lambda 表达式
    public void test3() {
        inventory.sort((Apple a1, Apple a2) -> a1.getWeight() - a2.getWeight());
    }
    
    @Test
    // 4.使用Comparator的comparing方法，它可以接受一个 Function 来提取 Comparable 键值
    public void test4() {
        Comparator<Apple> c = Comparator.comparing((Apple a) -> a.getWeight());
        inventory.sort(c);
    }
    
    @Test
    // 5.使用方法引用
    public void test5() {
        Comparator<Apple> c = Comparator.comparing(Apple::getWeight);
        inventory.sort(c);
        // 逆序
        inventory.sort(c.reversed());
    }
    
    // 6.谓词复合和函数复合
}
