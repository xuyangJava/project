package com.siping.设计模式.模版方法;

/**
 * @date 2018年1月4日 上午11:50:26
 * @author yangxu
 * @version 1.0
 */
public class TemplateMethodPattern {

    public static void main(String[] args) {
        AbstractClass objA = new ConcreteClassA();
        AbstractClass objB = new ConcreteClassB();    
        objA.TemplateMethod();
        objB.TemplateMethod();
    }
}
