package com.siping.设计模式.责任链.模式1;

/**
 * 具体的处理者，如果有后继者，则交给后继者处理，没有的话自己处理
 * @date 2018年1月4日 下午3:18:46
 * @author yangxu
 * @version 1.0
 */
public class ConcreteHandler extends Handler {

    @Override
    public void handleRequest() {
        if(getSuccessor() != null) {
            System.out.println("交给后继者处理");
            getSuccessor().handleRequest();
        }else {
            System.out.println("自己处理请求");
        }
    }

}
