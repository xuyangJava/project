package com.siping.设计模式.观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2018年1月4日 下午2:18:35
 * @author yangxu
 * @version 1.0
 */
public class Feed implements Subject {

    private final List<Observer> observers = new ArrayList<>();
    @Override
    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void notifyObservers(String tweet) {
        /*for (Observer o : observers) {
            o.notify(tweet);
        }*/
        observers.forEach(o -> o.notify(tweet));
    }

}
