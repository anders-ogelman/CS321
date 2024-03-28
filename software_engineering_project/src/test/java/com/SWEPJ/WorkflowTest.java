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

    @Ignore
    @Test
    public void testReviewAccess() {
        Form[] test = WorkflowManager.info(1);
        Boolean[] fails = test[0].getFail();
        for (int i = 0; i < 9; i++) {
            if (fails[i])
                assertTrue(false);
        }
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
        fails = test[1].getFail();
        for (int i = 0; i < 9; i++) {
            if (fails[i])
                assertTrue(false);
        }
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

    @Ignore
    @Test
    public void testApproveAccess() {
        Form[] test = WorkflowManager.info(2);
        Boolean[] fails = test[0].getFail();
        for (int i = 0; i < 9; i++) {
            if (fails[i])
                assertTrue(false);
        }
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
        fails = test[1].getFail();
        for (int i = 0; i < 9; i++) {
            if (fails[i])
                assertTrue(false);
        }
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

    @Ignore
    @Test
    public void testEntryPush() {
        long PID = 111111111;
        long[] related = { 444444444 };
        String[] relation = { "tester" };
        Form tester = new Form(PID, "1/1/2000", "NULL", relation, "First", "Middle", "last", "email@address.com",
                related);
        Boolean result = WorkflowManager.update(0, tester, 1);
        File workflow = new File("Workflow.txt");
        try {
            Scanner s = new Scanner(workflow);
            s.nextLine();
            String updatedWF = s.nextLine();
            s.close();
            assertTrue(result
                    && updatedWF.equals("REVIEWER_TASKS = [111111111/father, 111111111/mother, 1111111111/tester]"));
        } catch (Exception e) {
            assertTrue(false);
        }
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
    }

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
