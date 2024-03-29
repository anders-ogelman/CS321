package com.SWEPJ;

import java.io.File;
import java.util.Scanner;

public class DatabaseManager {
    private static String fileName = "Database.txt";
    private static String lock0str = "0db.lock";
    private static String lock1str = "1db.lock";
    private static String lock2str = "2db.lock";

    // 0 = called by entry
    // 1 = called by review
    // 2 = called by approve
    // PID = pid of person who filled out form/person to lookup
    // related = related immigrant to lookup, if only doing a lookup for one person,
    // leave this field as an empty string
    // skip is used internally and should always be set to false
    // ret null if error
    // ret form, and form of related if read
    @SuppressWarnings("resource")
    public static Form[] fetch(int db, long PID, String related, Boolean skip) {
        try {
            Thread.sleep(10000);
            File database = new File(fileName);
            File lock0 = new File(lock0str);
            File lock1 = new File(lock1str);
            File lock2 = new File(lock2str);
            Scanner s = new Scanner(database);
            int test = 0;
            // MULTITHREAD FILE LOCK
            if (skip == false) {
                switch (db) {
                    case 0:
                        do {
                            test = 0;
                            while (lock1.exists() || lock2.exists()) {
                                Thread.sleep(1000);
                            }
                            lock0.createNewFile();
                            if (lock1.exists() || lock2.exists()) {
                                test = 1;
                                lock0.delete();
                            }
                        } while (test == 1);
                        break;
                    case 1:
                        do {
                            test = 0;
                            while (lock0.exists() || lock2.exists()) {
                                Thread.sleep(1000);
                            }
                            lock1.createNewFile();
                            if (lock0.exists() || lock2.exists()) {
                                test = 1;
                                lock1.delete();
                            }
                        } while (test == 1);
                        break;
                    case 2:
                        do {
                            test = 0;
                            while (lock1.exists() || lock0.exists()) {
                                Thread.sleep(1000);
                            }
                            lock2.createNewFile();
                            if (lock1.exists() || lock0.exists()) {
                                test = 1;
                                lock2.delete();
                            }
                        } while (test == 1);
                        break;
                    default:
                        throw new Exception("Invalid access number");

                }
            }
            File currLock = new File(Integer.toString(db) + "db.lock");
            while (s.hasNextLine()) {
                System.out.println(s.nextLine()); // WRITE READING CODE HERE
            }
            s.close();
            currLock.delete();
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
    // ret true if worked

    @SuppressWarnings("resource")
    public static boolean update(int db, Form form) {
        try {
            File database = new File(fileName);
            File lock0 = new File(lock0str);
            File lock1 = new File(lock1str);
            File lock2 = new File(lock2str);
            Scanner s = new Scanner(database);
            int test = 0;
            // MULTITHREAD FILE LOCK
            switch (db) {
                case 0:
                    do {
                        test = 0;
                        while (lock1.exists() || lock2.exists()) {
                            Thread.sleep(1000);
                        }
                        lock0.createNewFile();
                        if (lock1.exists() || lock2.exists()) {
                            test = 1;
                            lock0.delete();
                        }
                    } while (test == 1);
                    break;
                case 1:
                    do {
                        test = 0;
                        while (lock0.exists() || lock2.exists()) {
                            Thread.sleep(1000);
                        }
                        lock1.createNewFile();
                        if (lock0.exists() || lock2.exists()) {
                            test = 1;
                            lock1.delete();
                        }
                    } while (test == 1);
                    break;
                case 2:
                    do {
                        test = 0;
                        while (lock1.exists() || lock0.exists()) {
                            Thread.sleep(1000);
                        }
                        lock2.createNewFile();
                        if (lock1.exists() || lock0.exists()) {
                            test = 1;
                            lock2.delete();
                        }
                    } while (test == 1);
                    break;
                default:
                    throw new Exception("Invalid access number");

            }
            File currLock = new File(Integer.toString(db) + ".lock");
            while (s.hasNextLine()) {
                System.out.println(s.nextLine()); // WRITE SAVING CODE HERE
            }
            s.close();
            currLock.delete();
            return true;
        } catch (Exception e) {
            System.out.println("read failed");
            return false;
        }
    }
}
