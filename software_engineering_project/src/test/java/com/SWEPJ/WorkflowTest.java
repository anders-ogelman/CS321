package com.SWEPJ;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

import org.junit.After;
import org.junit.Test;
import org.junit.Ignore;

public class WorkflowTest {

	//tester for the review stage being able to access the results of the data entry stage
    @Ignore
    @Test
    public void testReviewAccess() {
        Form[] test = WorkflowManager.info(1);

	//test to make sure the queued item returns properly
	assertTrue(test != null && test[0] != null && test[1] != null);

	//ensures that the data verification array is initialized with the correct (false) boolean values
        Boolean[] fails = test[0].getFail();
        for (int i = 0; i < 9; i++) {
            if (fails[i])
                assertTrue(false);
        }

	//the following tests are written with information about a 
	//specific fictional requestor in mind, with the idea being that if everything works correctly,
	//this requestor's information will be transferred into the desired form object 
	//in a way that causes all of these tests to pass
        if (test[0].getPID() != 1111111111)
            assertTrue(false);
        if (!(test[0].getRelation()[1].equals("father")))
            assertTrue(false);
        if (!(test[0].getDOB().equals("1/1/1990")))
            assertTrue(false);
        if (!(test[0].getDOD().equals("NULL")))
            assertTrue(false);
        if (!(test[0].getFirstName().equals("Jill")))
            assertTrue(false);
        if (!(test[0].getMiddleName().equals("NULL")))
            assertTrue(false);
        if (!(test[0].getLastName().equals("Doe")))
            assertTrue(false);
        if (!(test[0].getEmail().equals("jill@doe.com")))
            assertTrue(false);
        if (test[0].getRelatedPID()[1] != 333333333)
            assertTrue(false);
        
	
	//ensures that the data verification array is initialized with the correct (false) boolean values
	fails = test[1].getFail();
        for (int i = 0; i < 9; i++) {
            if (fails[i])
                assertTrue(false);
        }
       
	//the following tests are written with information about a 
	//specific fictional requestee in mind, with the idea being that if everything works correctly,
	//this requestee's information will be transferred into the desired form object 
	//in a way that causes all of these tests to pass
       if (test[0].getPID() != 333333333)
            assertTrue(false);
        if (!(test[1].getRelation()[0].equals("")))
            assertTrue(false);
        if (!(test[1].getDOB().equals("1/1/1970")))
            assertTrue(false);
        if (!(test[1].getDOD().equals("12/30/2012")))
            assertTrue(false);
        if (!(test[1].getFirstName().equals("John")))
            assertTrue(false);
        if (!(test[1].getMiddleName().equals("Scott")))
            assertTrue(false);
        if (!(test[1].getLastName().equals("Doe")))
            assertTrue(false);
        if (!(test[1].getEmail().equals("john@doe.com")))
            assertTrue(false);
        File currLock;
        for (int i = 0; i < 3; i++) {
            currLock = new File(Integer.toString(i) + "db.lock");
            if (currLock.exists())
                assertTrue(false);
        }
        assertTrue(true);
    }

	//tester for approval step being able to access the results of the review stage
    @Ignore
    @Test
    public void testApproveAccess() {
    	
	//attempts to get the item at the end of the current workflow queue for the approval stage 
        Form[] test = WorkflowManager.info(2);
	
	//test to make sure the queued item returns properly
	assertTrue(test != null && test[0] != null && test[1] != null);
	
	//ensures that the data verification array is initialized with the correct values (false)
        Boolean[] fails = test[0].getFail();
        for (int i = 0; i < 9; i++) {
            if (fails[i])
                assertTrue(false);
        }
		
	//the following tests are written with information about a 
	//specific fictional requestor in mind, with the idea being that if everything works correctly,
	//this requestor's information will be transferred into the desired form object 
	//in a way that causes all of these tests to pass
        if (test[0].getPID() != 1111111111)
            assertTrue(false);
        if (!(test[0].getRelation()[1].equals("father")))
            assertTrue(false);
        if (!(test[0].getDOB().equals("1/1/1990")))
            assertTrue(false);
        if (!(test[0].getDOD().equals("NULL")))
            assertTrue(false);
        if (!(test[0].getFirstName().equals("Jill")))
            assertTrue(false);
        if (!(test[0].getMiddleName().equals("NULL")))
            assertTrue(false);
        if (!(test[0].getLastName().equals("Doe")))
            assertTrue(false);
        if (!(test[0].getEmail().equals("jill@doe.com")))
            assertTrue(false);
        if (test[0].getRelatedPID()[1] != 333333333)
            assertTrue(false);

        
	//ensures that the data verification array is initialized with the correct values (false) for the 
	//person whose records are being requested
	fails = test[1].getFail();
        for (int i = 0; i < 9; i++) {
            if (fails[i])
                assertTrue(false);
        }

	//the following tests are written with information about a 
	//specific fictional requestee in mind, with the idea being that if everything works correctly,
	//this requestee's information will be transferred into the desired form object 
	//in a way that causes all of these tests to pass
        if (test[0].getPID() != 333333333)
            assertTrue(false);
        if (!(test[1].getRelation()[0].equals("")))
            assertTrue(false);
        if (!(test[1].getDOB().equals("1/1/1970")))
            assertTrue(false);
        if (!(test[1].getDOD().equals("12/30/2012")))
            assertTrue(false);
        if (!(test[1].getFirstName().equals("John")))
            assertTrue(false);
        if (!(test[1].getMiddleName().equals("Scott")))
            assertTrue(false);
        if (!(test[1].getLastName().equals("Doe")))
            assertTrue(false);
        if (!(test[1].getEmail().equals("john@doe.com")))
            assertTrue(false);

	//tests to make sure that all file locks have been properly removed
        File currLock;
        for (int i = 0; i < 3; i++) {
            currLock = new File(Integer.toString(i) + "db.lock");
            if (currLock.exists())
                assertTrue(false);
        }
        assertTrue(true);
    }


	//tester for adding a form entered by the Data Enterer into the workflow table
    @Ignore
    @Test
    public void testEntryPush() {
        long PID = 111111111;
        long[] related = { 444444444 };
        String[] relation = { "tester" };
        Form tester = new Form(PID, "1/1/2000", "NULL", relation, "First", "Middle", "last", "email@address.com",
                related);

	//attempts to output information from the workflowmanager into the workflowmanager text file
        Boolean result = WorkflowManager.update(0, tester, 1);

	
        File workflow = new File("Workflow.txt");
        try {
            Scanner s = new Scanner(workflow);
            s.nextLine();
            String updatedWF = s.nextLine();
            s.close();
	    
	    //checks that WorkflowManager.update() pushed the previously specified data to the workflow table text file in the desired format
            assertTrue(result
                    && updatedWF.equals("REVIEWER_TASKS = [111111111/father, 111111111/mother, 1111111111/tester]"));
        } catch (Exception e) {
            assertTrue(false);
        }
	
	//tests for invalid inputs into the workflowmanager update method. Also, if these tests work properly,
	//no data should be added to the text files for the workflow manager
	assertTrue(!(WorkflowManager.update(0, tester, 2)));
	assertTrue(!(WorkflowManager.update(0, tester, -2)));
	assertTrue(!(WorkflowManager.update(4, tester, 1)));
	assertTrue(!(WorkflowManager.update(0, null, 1)));


    }

    @Ignore
    @Test
    public void testReviewPush() {
        long PID = 111111111;
        long[] related = { 444444444 };
        String[] relation = { "tester" };
        Form tester = new Form(PID, "1/1/2000", "NULL", relation, "First", "Middle", "last", "email@address.com",
                related);
        Boolean result = WorkflowManager.update(1, tester, 1);
        File workflow = new File("Workflow.txt");
        try {
            Scanner s = new Scanner(workflow);
            s.nextLine();
            s.nextLine();
            String updatedWF = s.nextLine();
            s.close();
            assertTrue(result
                    && updatedWF.equals("APPROVER_TASKS = [111111111/father, 111111111/mother, 1111111111/tester]"));
        } catch (Exception e) {
            assertTrue(false);
        }

	//tests for invalid inputs into the workflowmanager update method. Also, if these tests work properly,
	//no data should be added to the text files for the workflow manager
	assertTrue(!(WorkflowManager.update(1, tester, 2)));
	assertTrue(!(WorkflowManager.update(1, tester, -2)));
	assertTrue(!(WorkflowManager.update(-1, tester, 1)));
	assertTrue(!(WorkflowManager.update(1, null, 1)));


    }

    @Ignore
    @Test
    public void testReviewPull() {
        long PID = 111111111;
        long[] related = { 444444444 };
        String[] relation = { "tester" };
        Form tester = new Form(PID, "1/1/2000", "NULL", relation, "First", "Middle", "last", "email@address.com",
                related);
        Boolean result = WorkflowManager.update(2, tester, -1);
        File workflow = new File("Workflow.txt");
        try {
            Scanner s = new Scanner(workflow);
            s.nextLine();
            s.nextLine();
            String updatedWF = s.nextLine();
            s.close();
            assertTrue(result
                    && updatedWF.equals("REVIEWER_TASKS = [111111111/father, 111111111/mother]"));
        } catch (Exception e) {
            assertTrue(false);
        }

	//tests for invalid inputs into the workflowmanager update method. Also, if these tests work properly,
	//no data should be added to the text files for the workflow manager
	assertTrue(!(WorkflowManager.update(2, null, 1)));

    }

    @Ignore
    @Test
    public void testApprovePush() {
        long PID = 111111111;
        long[] related = { 444444444 };
        String[] relation = { "tester" };
        Form tester = new Form(PID, "1/1/2000", "NULL", relation, "First", "Middle", "last", "email@address.com",
                related);
        Boolean result = WorkflowManager.update(2, tester, 1);
        File workflow = new File("Workflow.txt");
        try {
            Scanner s = new Scanner(workflow);
            s.nextLine();
            s.nextLine();
            String updatedWF = s.nextLine();
            s.close();
            assertTrue(result
                    && updatedWF.equals("APPROVER_TASKS = [111111111/father, 111111111/mother]"));
        } catch (Exception e) {
            assertTrue(false);
        }

	//tests for invalid inputs into the workflowmanager update method. Also, if these tests work properly,
	//no data should be added to the text files for the workflow manager
	assertTrue(!(WorkflowManager.update(2, tester, 2))); 
	assertTrue(!(WorkflowManager.update(2, tester, -2)));
	assertTrue(!(WorkflowManager.update(-2, tester, 1)));
	assertTrue(!(WorkflowManager.update(2, null, 1)));

    }

    @Ignore
    @Test
    public void testApprovePull() {
        long PID = 111111111;
        long[] related = { 444444444 };
        String[] relation = { "tester" };
        Form tester = new Form(PID, "1/1/2000", "NULL", relation, "First", "Middle", "last", "email@address.com",
                related);
        Boolean result = WorkflowManager.update(2, tester, -1);
        File workflow = new File("Workflow.txt");
        try {
            Scanner s = new Scanner(workflow);
            s.nextLine();
            s.nextLine();
            String updatedWF = s.nextLine();
            s.close();
            assertTrue(result
                    && updatedWF.equals("REVIEWER_TASKS = [111111111/father, 111111111/mother, 1111111111/tester]"));
        } catch (Exception e) {
            assertTrue(false);
        }

	//tests for invalid inputs into the workflowmanager update method. Also, if these tests work properly,
	//no data should be added to the text files for the workflow manager
	assertTrue(!(WorkflowManager.update(3, tester, -1))); 
	assertTrue(!(WorkflowManager.update(2, tester, -2)));
	assertTrue(!(WorkflowManager.update(-2, tester, 1)));
	assertTrue(!(WorkflowManager.update(2, null, 1)));


    }
	
	//method to reset the workflow text file to its original state after testing, so further testing can be consistent
	//part of this is populating the workflow file with the example requestor's information found throughout these
	//tests
    @After
    public void cleanup() {
        try {
            Path replaceMe = Paths.get("Workflow.txt");
            Path replacement = Paths.get("backup/Workflow.txt");
            Files.copy(replacement, replaceMe, StandardCopyOption.REPLACE_EXISTING);
            File currLock;
            for (int i = 0; i < 3; i++) {
                currLock = new File(Integer.toString(i) + "wf.lock");
                if (currLock.exists())
                    currLock.delete();
            }
        } catch (Exception e) {
            System.err.println("manual workflow replacement required");
        }
    }

}
