package com.siping.设计模式.模版方法;

/**
 * 模板方法模式中的三类角色
 *   1、具体方法(Concrete Method)
 *   2、抽象方法(Abstract Method)
 *   3、钩子方法(Hook Method) 
 * 三类角色的关联
 *  在模板方法模式中，首先父类会定义一个算法的框架，即实现算法所必须的所有方法。
 *  其中，具有共性的代码放在父类的具体方法中。
 *  各个子类特殊性的代码放在子类的具体方法中。但是父类中需要有对应抽象方法声明。
 *  钩子方法可以让子类决定是否对算法的不同点进行挂钩。 
 * @date 2018年1月4日 上午11:48:22
 * @author yangxu
 * @version 1.0
 */
public abstract class AbstractClass {

    public abstract void PrimitiveOperation1();
    public abstract void PrimitiveOperation2();
    
    // 钩子方法，子类决定是否执行方法
    public boolean hookMethod() {
        return true;
    }
    
    public void TemplateMethod() {
        PrimitiveOperation1();
        if(hookMethod()) {
            PrimitiveOperation2();
        }
    }
}
