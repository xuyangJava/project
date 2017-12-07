package com.siping.并发;

public class B_MoreBaseThread {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            B_LiftOff l = new B_LiftOff();
            Thread t = new Thread(l);
            t.start();
            System.out.println(t.getName() + "================================");
        }
    }
}
