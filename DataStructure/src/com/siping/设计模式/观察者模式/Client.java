package com.siping.设计模式.观察者模式;

/**
 * @date 2018年1月4日 下午2:21:36
 * @author yangxu
 * @version 1.0
 */
public class Client {
    
    public static void main(String[] args) {
        Feed f = new Feed();
        f.registerObserver(new NYTimes());
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());
        f.notifyObservers("The queen said her favourite book is Java 8 in Action!");
    }
}
