package com.SWEPJ;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.After;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class DatabaseManagerTest {

    // No need to check for wrong user input as isValid() in Form() already does
    // this
    @Ignore
    @Test
    public void testDualAccess() {
        Form[] test = DatabaseManager.fetch(1, 1111111111, "father", false);
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
    public void testSingleAccess() {
        Form[] test = DatabaseManager.fetch(1, 222222222, "", false);
        Boolean[] fails = test[0].getFail();
        for (int i = 0; i < 9; i++) {
            if (fails[i])
                assertTrue(false);
        }
        if (test[0].getPID() != 1111111111)
            assertTrue(false);
        if (!(test[0].getRelation()[0].equals("")))
            assertTrue(false);
        if (!(test[0].getDOB().equals("1/1/1970")))
            assertTrue(false);
        if (!(test[0].getDOD().equals("12/30/2012")))
            assertTrue(false);
        if (!(test[0].getFirstName().equals("Jane")))
            assertTrue(false);
        if (!(test[0].getMiddleName().equals("NULL")))
            assertTrue(false);
        if (!(test[0].getLastName().equals("Doe")))
            assertTrue(false);
        if (!(test[0].getEmail().equals("jane@doe.com")))
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
    public void testUpdate() {
        long PID = 111111111;
        long[] related = { 222222222 };
        String[] relation = { "tester" };
        Form tester = new Form(PID, "1/1/2000", "NULL", relation, "First", "Middle", "last", "email@address.com",
                related);
        // "Last", "test@gmail.com");
        DatabaseManager.update(1, tester);
        Form[] test = DatabaseManager.fetch(1, 1111111111, "", false);
        Boolean[] fails = test[0].getFail();
        for (int i = 0; i < 9; i++) {
            if (fails[i])
                assertTrue(false);
        }
        if (test[0].getPID() != 1111111111)
            assertTrue(false);
        if (!(test[0].getRelation()[0].equals("tester")))
            assertTrue(false);
        if (!(test[0].getDOB().equals("1/1/2000")))
            assertTrue(false);
        if (!(test[0].getDOD().equals("NULL")))
            assertTrue(false);
        if (!(test[0].getFirstName().equals("First")))
            assertTrue(false);
        if (!(test[0].getMiddleName().equals("Middle")))
            assertTrue(false);
        if (!(test[0].getLastName().equals("Last")))
            assertTrue(false);
        if (!(test[0].getEmail().equals("email@address.com")))
            assertTrue(false);
        if (test[0].getRelatedPID()[0] != 222222222)
            assertTrue(false);
        assertTrue(true);
    }

    @After
    public void cleanup() {
        try {
            Path replaceMe = Paths.get("Database.txt");
            Path replacement = Paths.get("backup/Database.txt");
            Files.copy(replacement, replaceMe, StandardCopyOption.REPLACE_EXISTING);
            File currLock;
            for (int i = 0; i < 3; i++) {
                currLock = new File(Integer.toString(i) + "db.lock");
                if (currLock.exists())
                    currLock.delete();
            }
        } catch (Exception e) {
            System.err.println("manual database replacement required");
        }
    }
}
