package com.SWEPJ;

import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;

public class WorkflowManager {
    private static String fileName = "Workflow.txt";
    // private static String lock0str = "0wf.lock";
    // private static String lock1str = "1wf.lock";
    // private static String lock2str = "2wf.lock";

    // 1 = called by review
    // 2 = called by approve
    // ret null if error
    // returns the next form FID to process
    public static Long info(int wf) {
        File database = new File(fileName);
        String queue;
        try {
            Scanner s = new Scanner(database);
            // StringBuffer b = new StringBuffer();
            switch (wf) {
                case 1:
                case 2:
                    queue = s.nextLine();
                    queue += '\n';
                    queue += s.nextLine();
                    break;
                default:
                    s.close();
                    return null;
            }
            System.out.println(queue);
            s.close();

        } catch (Exception e) {
            return null;
        }
        String[] queues, elements;
        try {
            queues = queue.split("\n");
            String curr = queues[wf - 1].split("=")[1];
            elements = curr.split(",");
        } catch (Exception e) {
            return null;
        }

        String overwrite = "";
        switch (wf) {
            case 1:
                overwrite = "REVIEWER_TASKS=";
                break;
            case 2:
                overwrite = "APPROVER_TASKS=";
                break;
        }
        for (int i = 1; i < elements.length; i++) {
            if (i != elements.length - 1) {
                overwrite += elements[i];
                overwrite += ',';
            } else {
                overwrite += elements[i];
                // overwrite += '\n';
            }
        }
        queue = queue.replaceAll(queues[wf - 1], overwrite);
        System.out.println("\n" + queue + "\n");
        try {
            FileWriter w = new FileWriter(fileName);
            w.append(queue);
            w.flush();
            w.close();

        } catch (Exception e) {
            return null;
        }
        // System.out.println(overwrite);
        return Long.parseLong(elements[0]);
        /*
         * try {
         * File database = new File(fileName);
         * File lock0 = new File(lock0str);
         * File lock1 = new File(lock1str);
         * File lock2 = new File(lock2str);
         * Scanner s = new Scanner(database);
         * int test = 0;
         * // MULTITHREAD FILE LOCK
         * switch (wf) {
         * case 1:
         * do {
         * test = 0;
         * while (lock0.exists() || lock2.exists()) {
         * Thread.sleep(1000);
         * }
         * lock1.createNewFile();
         * if (lock0.exists() || lock2.exists()) {
         * test = 1;
         * lock1.delete();
         * }
         * } while (test == 1);
         * break;
         * case 2:
         * do {
         * test = 0;
         * while (lock1.exists() || lock0.exists()) {
         * Thread.sleep(1000);
         * }
         * lock2.createNewFile();
         * if (lock1.exists() || lock0.exists()) {
         * test = 1;
         * lock2.delete();
         * }
         * } while (test == 1);
         * break;
         * default:
         * throw new Exception("Invalid access number");
         * 
         * }
         * File currLock = new File(Integer.toString(wf) + "wf.lock");
         * while (s.hasNextLine()) {
         * System.out.println(s.nextLine()); // WRITE READING CODE HERE
         * }
         * s.close();
         * currLock.delete();
         * return null;
         * } catch (Exception e) {
         * System.out.println("read failed");
         * return null;
         * }
         */
    }

    // wf = 0 = called by entry
    // wf = 1 = called by review
    // wf = 2 = called by approve
    // Form = form to push in the workflow, will probably just write PID and related
    // PID
    // action = 0 = push forward
    // action = 1 = push backward
    // ret false if error
    public static boolean update(int wf, long FID) {
        File database = new File(fileName);
        String queue;
        try {
            Scanner s = new Scanner(database);
            // StringBuffer b = new StringBuffer();
            switch (wf) {
                case 0:
                case 1:
                case 2:
                    queue = s.nextLine();
                    queue += '\n';
                    queue += s.nextLine();
                    break;
                default:
                    s.close();
                    return false;
            }
            System.out.println(queue);
            s.close();

        } catch (Exception e) {
            return false;
        }
        String[] queues;
        queues = queue.split("\n");
        String overwrite = queues[wf % 2];
        /*
         * switch (wf) {
         * case 0:
         * overwrite = queues[0];
         * break;
         * case 1:
         * overwrite = queues[1];
         * break;
         * case 2:
         * overwrite = queues[0];
         * break;
         * }
         */
        if (!(queues[wf % 2].equals("REVIEWER_TASKS=") || queues[wf % 2].equals("APPROVER_TASKS=")))
            overwrite += ",";
        overwrite += Long.toString(FID);
        overwrite = queue = queue.replaceAll(queues[wf % 2], overwrite);
        /*
         * switch (wf) {
         * case 0:
         * overwrite = queue = queue.replaceAll(queues[0], overwrite);
         * break;
         * case 1:
         * overwrite = queue = queue.replaceAll(queues[1], overwrite);
         * break;
         * case 2:
         * overwrite = queue = queue.replaceAll(queues[0], overwrite);
         * break;
         * }
         */
        System.out.println("\n" + queue + "\n");
        try {
            FileWriter w = new FileWriter(fileName);
            w.append(queue);
            w.flush();
            w.close();

        } catch (Exception e) {
            return false;
        }
        // System.out.println(overwrite);
        return true;
        /*
         * try {
         * File database = new File(fileName);
         * File lock0 = new File(lock0str);
         * File lock1 = new File(lock1str);
         * File lock2 = new File(lock2str);
         * Scanner s = new Scanner(database);
         * int test = 0;
         * // MULTITHREAD FILE LOCK
         * switch (wf) {
         * case 0:
         * do {
         * test = 0;
         * while (lock1.exists() || lock2.exists()) {
         * Thread.sleep(1000);
         * }
         * lock0.createNewFile();
         * if (lock1.exists() || lock2.exists()) {
         * test = 1;
         * lock0.delete();
         * }
         * } while (test == 1);
         * break;
         * case 1:
         * do {
         * test = 0;
         * while (lock0.exists() || lock2.exists()) {
         * Thread.sleep(1000);
         * }
         * lock1.createNewFile();
         * if (lock0.exists() || lock2.exists()) {
         * test = 1;
         * lock1.delete();
         * }
         * } while (test == 1);
         * break;
         * case 2:
         * do {
         * test = 0;
         * while (lock1.exists() || lock0.exists()) {
         * Thread.sleep(1000);
         * }
         * lock2.createNewFile();
         * if (lock1.exists() || lock0.exists()) {
         * test = 1;
         * lock2.delete();
         * }
         * } while (test == 1);
         * break;
         * default:
         * throw new Exception("Invalid access number");
         * 
         * }
         * File currLock = new File(Integer.toString(wf) + ".lock");
         * // while (s.hasNextLine()) {
         * // System.out.println(s.nextLine()); // WRITE SAVING CODE HERE
         * // }
         * s.close();
         * currLock.delete();
         * return true;
         * } catch (Exception e) {
         * System.out.println("read failed");
         * return false;
         * }
         * }
         */
    }

}
