package com.siping.并发;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 重载静态的ExecutorService
 * @author siping-yx
 * @date 2017年11月10日
 * @version 1.0
 *
 */
public class D_DeamonThreadPoolExecutor extends ThreadPoolExecutor {

    public D_DeamonThreadPoolExecutor() {
        super(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new D_DaemonThreadFactory());
    }

}
