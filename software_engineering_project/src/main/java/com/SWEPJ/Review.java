package com.SWEPJ;

public class Review extends Thread {
    Review() { // code written here is not concurrent and will hold up everyone elses code
    }

    public void run() {
        try {// thread.sleep requires try/catch, idk why lol
            Thread.sleep(100000);// code written here is concurrent, even though my program will wait for 100
                                 // seconds, yours will not
        } catch (Exception e) {
        }
    }
}
