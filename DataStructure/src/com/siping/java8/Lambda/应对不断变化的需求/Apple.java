package com.siping.java8.Lambda.应对不断变化的需求;

public class Apple {

    public Apple() {
        super();
    }
    public Apple(String color, int weight) {
        super();
        this.color = color;
        this.weight = weight;
    }
    private String color;
    private int weight;
    
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
}
