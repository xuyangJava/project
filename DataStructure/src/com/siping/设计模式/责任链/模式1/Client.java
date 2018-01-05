package com.siping.设计模式.责任链.模式1;

/**
 * @date 2018年1月4日 下午3:20:56
 * @author yangxu
 * @version 1.0
 */
public class Client {

    public static void main(String[] args) {
        //组装责任链
        Handler handler1 = new ConcreteHandler();
        Handler handler2 = new ConcreteHandler();
        handler1.setSuccessor(handler2);
        //提交请求
        handler1.handleRequest();
    }
}
