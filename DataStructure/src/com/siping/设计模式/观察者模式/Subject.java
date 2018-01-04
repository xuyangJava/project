package com.siping.设计模式.观察者模式;

/**
 * @date 2018年1月4日 下午2:17:25
 * @author yangxu
 * @version 1.0
 */
public interface Subject {

    void registerObserver(Observer o);
    void notifyObservers(String tweet);
}
