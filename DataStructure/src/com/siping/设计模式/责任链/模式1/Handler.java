package com.siping.设计模式.责任链.模式1;

/**
 * 抽象处理者
 * @date 2018年1月4日 下午3:16:13
 * @author yangxu
 * @version 1.0
 */
public abstract class Handler {

    /**
     * 持有后继的责任对象
     */
    protected Handler successor;
    
    /**
     * 示意处理请求的方法，虽然这个示意方法是没有传入参数的
     * 但实际是可以传入参数的，根据具体需要来选择是否传递参数
     * @date 2018年1月4日 下午3:17:57
     * @author yangxu
     */
    public abstract void handleRequest();

    public Handler getSuccessor() {
        return successor;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
    
    
}
