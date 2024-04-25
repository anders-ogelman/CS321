package com.SWEPJ;

import java.io.File;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class DatabaseManager {

    private static String fileName = "Database.txt";

    // PID = pid of requester
    // returns all the forms submitted by the requester
    public static Form fetch(long FID) {
        File database = new File(fileName);
        Form form = null;
        try {
            Scanner s = new Scanner(database);
            while (s.nextLine().equals("~")) {
                String FIDs = s.nextLine();
                String[] split = FIDs.split("=");
                if (Long.parseLong(split[1]) == FID)
                    break;
                for (int i = 0; i < 8; i++) {
                    s.nextLine();
                }
                // System.out.println(s.nextLine());

            }
            long PID = Long.parseLong(s.nextLine().split("=")[1]);
            String[] split = s.nextLine().split("=")[1].split(" ");
            String relation = split[1];
            long relatedPID = Long.parseLong(split[0]);
            String DOB = s.nextLine().split("=")[1];
            String DOD = s.nextLine().split("=")[1];
            String firstName = s.nextLine().split("=")[1];
            String middleName = "";
            try {
                middleName = s.nextLine().split("=")[1];
            } catch (Exception e) {
            }
            String lastName = s.nextLine().split("=")[1];
            String email = s.nextLine().split("=")[1];
            form = new Form(PID, DOB, DOD, relation, firstName, middleName, lastName,
                    email, relatedPID);
            form.setFID(FID);
            s.close();
            // while(s.nextLine(0 != "X"))

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
        return form;
    }

    // form = form being saved
    // ret false if error
    // ret true if worked

    public static boolean update(Form form) {

        // only implementing the adding new form functionality - somebody else will add
        // updating
        if (form.getFID() == -1) {

        }

        return true;
    }

    private void resetDatabase() {

        try {
            Path replaceMe = Paths.get("Database.txt");
            Path replacement = Paths.get("backup/Database.txt");
            Files.copy(replacement, replaceMe, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            System.err.println("manual database replacement required");
        }
    }

}
