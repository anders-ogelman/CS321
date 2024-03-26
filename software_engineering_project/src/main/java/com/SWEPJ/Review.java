package com.SWEPJ;

public class Review extends Thread {
    Review() {
    }

    public void run() {
        System.out.println("Review working");
        long PID = 111111111;
        Form form = new Form(PID, "1/1/2000", "mother", "First", "Middle", "Last", "test@gmail.com");
        DatabaseManager.read(1, PID);
    }
}
