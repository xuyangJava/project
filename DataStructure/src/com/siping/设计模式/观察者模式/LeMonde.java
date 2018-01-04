package com.siping.设计模式.观察者模式;

public class LeMonde implements Observer {

    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("queen")) {
            System.out.println("Breaking news in LeMonde! " + tweet);
        }
    }

}
