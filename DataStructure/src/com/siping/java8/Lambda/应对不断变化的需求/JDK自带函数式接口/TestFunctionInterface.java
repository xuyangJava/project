package com.siping.java8.Lambda.应对不断变化的需求.JDK自带函数式接口;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

/**
 * @date 2018年1月4日 下午4:03:00
 * @author yangxu
 * @version 1.0
 */
public class TestFunctionInterface {

    @Test
    public void testFunction() {
        Function<Integer, String> f1 = (x) -> " test result : " + x;
        Function<String, String> f2 = (x) -> {
            return " after function1" + x;
        };
        // System.out.println(f1.apply(6));
        System.out.println(f1.andThen(f2).apply(6));
    }

    @Test
    public void testSupplier() {
        Supplier<Integer> s = () -> 1;
        System.out.println(s.get());
    }

    @Test
    public void testConsumer() {
        Consumer<Integer> c = (i) -> {
            System.out.println(i);
        };
        c.accept(5);
    }

    @Test
    public void testPredicate() {
        Predicate<Integer> p = (i) -> i < 10;
        List<Integer> list = Arrays.asList(1, 3, 9, 10, 12, 21);
        list.forEach((i) -> {
            System.out.println(i + " : " + p.test(i));
        });
    }
}
