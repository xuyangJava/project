package com.siping.java8.函数式数据处理;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class Demo1 {

    private List<Dish> menu = Arrays.asList(
        new Dish("pork", false, 800, Dish.Type.MEAT),
        new Dish("beef", false, 700, Dish.Type.MEAT),
        new Dish("chicken", false, 400, Dish.Type.MEAT),
        new Dish("french fries", true, 530, Dish.Type.OTHER),
        new Dish("rice", true, 350, Dish.Type.OTHER),
        new Dish("season fruit", true, 120, Dish.Type.OTHER),
        new Dish("pizza", true, 550, Dish.Type.OTHER),
        new Dish("prawns", false, 300, Dish.Type.FISH),
        new Dish("salmon", false, 450, Dish.Type.FISH) );
    
    @Test
    public void test1() {
        List<Integer> threeHighCaloricDishNames = menu.stream()
            .filter(d -> d.getCalories() > 500).map(Dish::getName).map(String::length)
            .collect(Collectors.toList());
        System.out.println(threeHighCaloricDishNames.toString());
    }
    
    /**
     * 给定两个数字列表，如何返回所有的数对呢？例如，给定列表[1, 2, 3]和列表[3, 4]，应
     * 该返回[(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]
     */
    @Test
    public void test2() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        
        List<Object> pairs = numbers1.stream().flatMap(i -> numbers2.stream().map(j -> {return new int[]{i, j};})).collect(Collectors.toList());
        System.out.println(pairs.toArray());
    }
}
