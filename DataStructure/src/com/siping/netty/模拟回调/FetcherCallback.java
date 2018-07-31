package com.siping.netty.模拟回调;

public interface FetcherCallback {
    void onData(Data data) throws Exception; 
    void onError(Throwable cause); 
}
