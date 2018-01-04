package com.siping.设计模式.模版方法;

/**
 * @date 2018年1月4日 上午11:49:05
 * @author yangxu
 * @version 1.0
 */
public class ConcreteClassA extends AbstractClass {

    @Override
    public void PrimitiveOperation1() {
        System.out.println("具体A类方法1");
    }

    @Override
    public void PrimitiveOperation2() {
        System.out.println("具体A类方法2");
    }

}
