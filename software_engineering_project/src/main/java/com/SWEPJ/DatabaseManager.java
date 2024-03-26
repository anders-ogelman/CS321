package com.SWEPJ;

import java.io.File;
import java.util.Scanner;

public class DatabaseManager {
    private static String fileName = "Database.txt";
    private static String lock0str = "0.lock";
    private static String lock1str = "1.lock";
    private static String lock2str = "2.lock";

    // 0 = called by entry
    // 1 = called by review
    // 2 = called by approve
    // ret null if error
    public static Form read(int db, long PID) {
        try {
            File database = new File(fileName);
            File lock0 = new File(lock0str);
            File lock1 = new File(lock1str);
            File lock2 = new File(lock2str);
            // File myObj = new File("filename.txt");
            // myObj.createNewFile();
            Scanner s = new Scanner(database);
            switch (db) {
                case 0:
                    while (lock1.exists() || lock2.exists()) {
                        Thread.sleep(10000);
                    }

            }
            File lock = new File(Integer.toString(db) + ".lock");
            int test = 0;
            lock.createNewFile();

            do {
                test = 0;
            } while (test > 0);

            while (s.hasNextLine()) {
                System.out.println(s.nextLine());
            }
            s.close();
            return null;
        } catch (Exception e) {
            System.out.println("read failed");

            return null;
        }
    }

    // 0 = called by
    // 1 = called by review
    // 2 = called by approve
    // ret false if error
    public static boolean save() {
        try {
            File database = new File(fileName);
            Scanner s = new Scanner(database);
            s.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
