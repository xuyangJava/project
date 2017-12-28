package com.siping.java8.Lambda.应对不断变化的需求;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.siping.java8.Lambda.应对不断变化的需求.行为参数化.ApplePredicate;
import com.siping.java8.Lambda.应对不断变化的需求.行为参数化.Predicate;

public class Demo1 {

    // 1.筛选绿色的苹果
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }
    
    // 2.第一步的进阶，把颜色作为参数传递
    public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if(color.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }
    
    // 3.筛选重量大于多少的苹果
    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if(apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }
    
    // 4.筛选苹果颜色和重量
    public static List<Apple> filterApples(List<Apple> inventory, String color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if ((flag && apple.getColor().equals(color)) || (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }
        return result;
    }
    
    // 5.行为参数化后的筛选
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
    
    // 6.使用匿名内部类
    // 但匿名类还是不够好。第一，它往往很笨重，因为它占用了很多空间
    public static List<Apple> filterApples(List<Apple> inventory) {
        List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor());
            }
        });
        return redApples;
    }
    
    // 7.使用Lambda表达式
    // 在函数式接口中可以使用Lambda，函数式接口就是只定义一个抽象方法的接口
    public static List<Apple> filterApplesByLambda(List<Apple> inventory) {
        List<Apple> result = filterApples(inventory, (Apple apple) -> "red".equals(apple.getColor()));
        return result;
    }
    
    // 将list类型抽象化,可以接收任何类型了
    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<T>();
        for (T t : list) {
            if(p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }
    // 8.使用抽象后的Lambda表达式
    public void testLambda(List<Apple> inventory) {
        List<Apple> redApples = filter(inventory, (Apple apple) -> "red".equals(apple));
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        List<Integer> evenNumber = filter(numbers, (Integer i) -> i % 2 == 0);
    }
}
