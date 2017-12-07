package com.siping.并发;

import java.util.concurrent.ThreadFactory;

/**
 * 设置自定义ThreadFactory，自定义由Executor创建自定义的线程，可以自定义设置线程的属性（后台、优先级、名称），
 * 可以使用该Thread Factoty创建线程
 * @author siping-yx
 * @date 2017年11月10日
 * @version 1.0
 *
 */
public class D_DaemonThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }

}
