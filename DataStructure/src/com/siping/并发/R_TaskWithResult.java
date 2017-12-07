package com.siping.并发;

import java.util.concurrent.Callable;

public class R_TaskWithResult implements Callable<String> {
    
    private int id;
    
    public R_TaskWithResult(int id) {
       this.id = id; 
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult : " + id;
    }

}
