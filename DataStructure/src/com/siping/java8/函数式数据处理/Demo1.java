package com.siping.java8.函数式数据处理;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        List<String> threeHighCaloricDishNames = menu.stream()
            .filter(d -> d.getCalories() > 500).map(Dish::getName)
            .limit(3).collect(Collectors.toList());
        System.out.println(threeHighCaloricDishNames.toString());
    }
}
