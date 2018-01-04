package com.siping.java8.Lambda.应对不断变化的需求.Lambda和方法引用实战;

import java.util.Comparator;

import com.siping.java8.Lambda.应对不断变化的需求.Apple;

public class AppleComparator implements Comparator<Apple> {

    @Override
    public int compare(Apple a1, Apple a2) {
        return a1.getWeight() - a2.getWeight();
    }

}
