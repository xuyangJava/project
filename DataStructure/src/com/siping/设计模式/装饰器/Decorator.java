package com.siping.设计模式.装饰器;

/**
 * 装饰器：所有装饰器的父类，需要定义一个与组件接口一致的接口(主要是为了实现装饰器功能的复用，即具体的装饰器A可以装饰另外一个具体的装饰器B，
 * 因为装饰器类也是一个Component)，并持有一个Component对象，该对象其实就是被装饰的对象。如果不继承组件接口类，则只能为某个组件
 * 添加单一的功能，即装饰器对象不能在装饰其他的装饰器对象。
 * @author siping-yx
 * @date 2017年12月11日
 * @version 1.0
 *
 */
public abstract class Decorator extends Component {

    protected Component component;
    
    public Decorator(Component component) {
        this.component = component;
    }
    
    public void operation() {
        component.operation();
    }
}
