package com.SWEPJ;

public class Approve extends Thread {
    Thread t;

    public Approve() {
        // this.t = new Thread(this);
        // this.t.start();
    }

    public void run() {
        System.out.println("Approve working");
        try {
            Thread.sleep(10000);
            System.out.println("done waiting");
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
