package com.SWEPJ;

import java.io.File;
import java.util.Scanner;
import java.io.*;
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

		try {
			Scanner s = new Scanner(database);
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	// form = form being saved
	// ret false if error
	// ret true if worked

	public static boolean update(Form form) {
		
		//only implementing the adding new form functionality - somebody else will add updating
		if(form.getFID() == -1) {
			

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
