package com.siping.netty.模拟回调;

/**
 * 异步示例1：使用回调
 *
 */
public class Worker {

    public void doWorker() {
        Fetcher fetcher = new MyFetcher(new Data(0, 1));
        fetcher.fetchData(new FetcherCallback() {
            
            @Override
            public void onError(Throwable cause) {
                System.out.println("An  error  accour:  " + cause.getMessage());
            }
            
            @Override
            public void onData(Data data) throws Exception {
                System.out.println("Data  received:  " + data);
                
            }
        });
    }
    
    public static void main(String[] args) {
        Worker w = new Worker();
        w.doWorker();
    }
}
