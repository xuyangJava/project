package com.siping.java8.Lambda.应对不断变化的需求.行为参数化;

import com.siping.java8.Lambda.应对不断变化的需求.Apple;

public class AppleGreenColorPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }

}
