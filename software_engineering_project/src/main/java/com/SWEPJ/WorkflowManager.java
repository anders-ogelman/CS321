package com.SWEPJ;

import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;

public class WorkflowManager {
    private static String fileName = "Workflow.txt";

    // 1 = called by review
    // 2 = called by approve
    // ret errRet if error
    // returns the next form FID to process, pops the first element in the queue
    public static Long info(int wf) {
        File database = new File(fileName);
        String queue;
        long errRet = -1;
        try {
            Scanner s = new Scanner(database);// scan the wf
            switch (wf) {
                case 1:
                case 2:
                    queue = s.nextLine();
                    queue += '\n';
                    queue += s.nextLine();// put everything into a string if inputs are correct
                    break;
                default:
                    s.close();
                    return errRet;
            }
            s.close();

        } catch (Exception e) {
            return errRet;
        }
        String[] queues, elements;
        try {
            queues = queue.split("\n");// break up the elements of the queue to be read
            String curr = queues[wf - 1].split("=")[1];
            elements = curr.split(",");
        } catch (Exception e) {
            return errRet;
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
        for (int i = 1; i < elements.length; i++) {// rebuild the queue, leaving out the first element
            if (i != elements.length - 1) {
                overwrite += elements[i];
                overwrite += ',';
            } else {
                overwrite += elements[i];
            }
        }
        queue = queue.replaceAll(queues[wf - 1], overwrite);// write the queue back into the string
        try {
            FileWriter w = new FileWriter(fileName);// write to the file
            w.append(queue);
            w.flush();
            w.close();

        } catch (Exception e) {
            return errRet;
        }
        // System.out.println(overwrite);
        return Long.parseLong(elements[0]);
    }

    // wf = 0 = called by entry
    // wf = 1 = called by review
    // wf = 2 = called by approve
    // FID = the fid to push into the queue
    // ret false if error, otherwise return true
    public static boolean update(int wf, long FID) {
        File database = new File(fileName);
        String queue;
        try {
            Scanner s = new Scanner(database);
            switch (wf) {
                case 0:
                case 1:
                case 2:
                    queue = s.nextLine();// put thr queues into a string if inputs are correct
                    queue += '\n';
                    queue += s.nextLine();
                    break;
                default:
                    s.close();
                    return false;
            }
            s.close();

        } catch (Exception e) {
            return false;
        }
        String[] queues;
        queues = queue.split("\n");
        String overwrite = queues[wf % 2];// select appropreate queue to edit
        if (!(queues[wf % 2].equals("REVIEWER_TASKS=") || queues[wf % 2].equals("APPROVER_TASKS=")))
            overwrite += ",";// if an item is already in the queue, add a comma
        overwrite += Long.toString(FID);// add the new fid
        overwrite = queue = queue.replaceAll(queues[wf % 2], overwrite);// overwrite the previous queue
        try {
            FileWriter w = new FileWriter(fileName);// write to file
            w.append(queue);
            w.flush();
            w.close();

        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
