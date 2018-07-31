package com.siping.netty.模拟回调;

public interface Fetcher {
    void fetchData(FetcherCallback fetcherCallback);
}
