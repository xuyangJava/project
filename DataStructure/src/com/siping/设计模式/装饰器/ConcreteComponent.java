package com.siping.设计模式.装饰器;

/**
 * 具体的组件对象，实现了组件接口。该对象通常就是被装饰器装饰的原始对象，可以给这个对象添加职责；具体的组件对象，实现了组件接口。
 * 该对象通常就是被装饰器装饰的原始对象，可以给这个对象添加职责；
 * @author siping-yx
 * @date 2017年12月11日
 * @version 1.0
 *
 */
public class ConcreteComponent extends Component {

    @Override
    public void operation() {
        // TODO Auto-generated method stub
        System.out.println("具体组件对象： operation...");
    }

}
