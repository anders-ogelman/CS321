package com.SWEPJ;

import java.io.File;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.io.IOException;
import java.io.FileWriter;


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
	
	File database = new File(fileName);

        if (form.getFID() == -1) {
		
		Scanner reader = null;
		Scanner fidScanner = null;
		try {
			reader = new Scanner(database);
			fidScanner = new Scanner(database);
		} catch (Exception e) {
			System.out.println("Scanner failed to open database");
			System.exit(-1);
		}

		//if this doesn't work, it may mean there is no X ending the database, and it isn't correctly formatted
		try {
			
			File tempFile = new File("temp.txt");
			tempFile.createNewFile();

			String currLine = reader.nextLine();
			
			FileWriter tempWriter = new FileWriter("temp.txt");

			//loop through the existing database until you get to the X at the end (not inclusive)
			//and copy them all into a new temp file
			while(currLine.charAt(0) != 'X') {
				tempWriter.write(currLine);
				tempWriter.write("\n");
				currLine = reader.nextLine();
			}


			//having reached the end of the file, add on the new form entry
			//TODO: properly handle FID
			tempWriter.write("~\n");
			tempWriter.write("FID=" + form.getFID() + "\n");
			tempWriter.write("PID=" + form.getPID() + "\n");
			tempWriter.write("DOB=" + form.getDOB() + "\n");
			tempWriter.write("DOD=" + form.getDOD() + "\n");
			tempWriter.write("FIRSTNAME=" + form.getFirstName() + "\n");
			tempWriter.write("MIDDLENAME=" + form.getMiddleName() + "\n");
			tempWriter.write("LASTNAME=" + form.getLastName() + "\n");
			tempWriter.write("EMAIL=" + form.getEmail() + "\n");
			tempWriter.write("X");

			System.out.println("Got here");

			//replace the original file with temp, delete temp
			try {
			    	Path replaceMe = Paths.get(fileName);
			    	Path replacement = Paths.get("temp.txt");
				System.out.println("Got past here");
			    	
				
				//closing the writer before deleting the file
				try {
					reader.close();
					tempWriter.close();
				} catch (IOException e) {
					System.out.println("Couldn't close file writer");
				}

				Files.copy(replacement, replaceMe, StandardCopyOption.REPLACE_EXISTING);

				tempFile.delete();

			} catch (Exception e) {
			    	System.err.println("Someting in temp file went wrong");
				System.err.println(e);
			}

		} catch (IOException e) {
			System.out.println("Problem with the FileWriter or file creator");
			System.exit(-1);
		}
		
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
