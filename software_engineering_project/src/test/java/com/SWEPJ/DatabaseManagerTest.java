package com.SWEPJ;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class DatabaseManagerTest {

    // No need to check for wrong user input as isValid() in Form() already does
    // this
    /*
     * @Ignore
     * 
     * @Test
     * public void testDualAccess() {
     * Form[] test = DatabaseManager.fetch(1, 1111111111, "father", false); //try to
     * get the father of a test person
     * Boolean[] fails = test[0].getFail();
     * for (int i = 0; i < 9; i++) {
     * if (fails[i])
     * assertTrue(false); //if the test form isn't found, then break out
     * }
     * //check test person's information
     * if (test[0].getPID() != 1111111111)
     * assertTrue(false);
     * if (!(test[0].getRelation().equals("father")))
     * assertTrue(false);
     * if (!(test[0].getDOB().equals("1/1/1990")))
     * assertTrue(false);
     * if (!(test[0].getDOD().equals("NULL")))
     * assertTrue(false);
     * if (!(test[0].getFirstName().equals("Jill")))
     * assertTrue(false);
     * if (!(test[0].getMiddleName().equals("NULL")))
     * assertTrue(false);
     * if (!(test[0].getLastName().equals("Doe")))
     * assertTrue(false);
     * if (!(test[0].getEmail().equals("jill@doe.com")))
     * assertTrue(false);
     * if (test[0].getRelatedPID()[1] != 333333333)
     * assertTrue(false);
     * fails = test[1].getFail();
     * for (int i = 0; i < 9; i++) {
     * if (fails[i])
     * assertTrue(false); //if the tester errors out
     * }
     * if (test[0].getPID() != 333333333)
     * assertTrue(false);
     * if (!(test[1].getRelation()[0].equals("")))
     * assertTrue(false);
     * if (!(test[1].getDOB().equals("1/1/1970")))
     * assertTrue(false);
     * if (!(test[1].getDOD().equals("12/30/2012")))
     * assertTrue(false);
     * if (!(test[1].getFirstName().equals("John")))
     * assertTrue(false);
     * if (!(test[1].getMiddleName().equals("Scott")))
     * assertTrue(false);
     * if (!(test[1].getLastName().equals("Doe")))
     * assertTrue(false);
     * if (!(test[1].getEmail().equals("john@doe.com")))
     * assertTrue(false);
     * File currLock;
     * for (int i = 0; i < 3; i++) {
     * currLock = new File(Integer.toString(i) + "db.lock");
     * if (currLock.exists())
     * assertTrue(false);
     * }
     * assertTrue(true);
     * }
     */

    @Test
    public void testAccess() {
        long PID2 = 222222222;
        Form test = DatabaseManager.fetch(1);
        assertTrue(test != null);
        Boolean[] fails = test.getFail();
        for (int i = 0; i < 9; i++) {
            if (fails[i])
                assertTrue(false);
        }
        assertTrue(test.getPID() == 111111111);
        assertTrue(test.getRelatedPID() == PID2);
        assertTrue(test.getRelation().equals("mother"));
        assertTrue(test.getDOB().equals("1/1/1990"));
        assertTrue(test.getDOD().equals("1/2/1930"));
        assertTrue(test.getFirstName().equals("Jill"));
        assertTrue(test.getMiddleName().equals(""));
        assertTrue(test.getLastName().equals("Doe"));
        assertTrue(test.getEmail().equals("jill@doe.com"));
    }

    @Test
    public void testAccess2() {
        long PID = 333333333;
        long PID2 = 444444444;
        Form test = DatabaseManager.fetch(2);
        assertTrue(test != null);
        Boolean[] fails = test.getFail();
        for (int i = 0; i < 9; i++) {
            if (fails[i])
                assertTrue(false);
        }
        assertTrue(test.getPID() == PID);
        assertTrue(test.getRelatedPID() == PID2);
        assertTrue(test.getRelation().equals("father"));
        assertTrue(test.getDOB().equals("1/1/1970"));
        assertTrue(test.getDOD().equals("12/30/1940"));
        assertTrue(test.getFirstName().equals("John"));
        assertTrue(test.getMiddleName().equals("Scott"));
        assertTrue(test.getLastName().equals("Doe"));
        assertTrue(test.getEmail().equals("john@doe.com"));
    }

    @Test
    public void testEdit() {
        Form form = new Form(111111111, "1/1/2000", "1/1/2000", "mother", "First", "Middle", "Last", "test@gmail.com",
                222222222);
        form.setFID(2);
        DatabaseManager.update(form);
        Form test = DatabaseManager.fetch(2);
        assertTrue(test != null);
        Boolean[] fails = test.getFail();
        for (int i = 0; i < 9; i++) {
            if (fails[i])
                assertTrue(false);
        }
        System.out.println(test.getPID());
        assertTrue(test.getPID() == 111111111);
        assertTrue(test.getRelatedPID() == 222222222);
        assertTrue(test.getRelation().equals("mother"));
        assertTrue(test.getDOB().equals("1/1/2000"));
        assertTrue(test.getDOD().equals("1/1/2000"));
        assertTrue(test.getFirstName().equals("First"));
        assertTrue(test.getMiddleName().equals("Middle"));
        assertTrue(test.getLastName().equals("Last"));
        assertTrue(test.getEmail().equals("test@gmail.com"));
    }

    @Test
    public void testinsert() {
        Form form = new Form(111111111, "1/1/2000", "1/1/2000", "mother", "First",
                "Middle", "Last", "test@gmail.com",
                222222222);
        DatabaseManager.update(form);
        Form test = DatabaseManager.fetch(3);
        assertTrue(test != null);
        Boolean[] fails = test.getFail();
        for (int i = 0; i < 9; i++) {
            if (fails[i])
                assertTrue(false);
        }
        assertTrue(test.getPID() == 111111111);
        assertTrue(test.getRelatedPID() == 222222222);
        assertTrue(test.getRelation().equals("mother"));
        assertTrue(test.getDOB().equals("1/1/2000"));
        assertTrue(test.getDOD().equals("1/1/2000"));
        assertTrue(test.getFirstName().equals("First"));
        assertTrue(test.getMiddleName().equals("Middle"));
        assertTrue(test.getLastName().equals("Last"));
        assertTrue(test.getEmail().equals("test@gmail.com"));
    }

    // Checks bad input into DatabaseManager's methods
    @Test
    public void testFetchInvalid() {
        assertTrue(DatabaseManager.fetch(3) == null); // check invalid access
    }

    @Test
    public void testFetchInvalidLookup() {
        assertTrue(DatabaseManager.fetch(-1) == null); // check incorrect PID lookup
    }

    /*
     * ~
     * FID=1
     * PID=111111111
     * RELATION=222222222 mother
     * DOB=1/1/1990
     * DOD=1/2/1930
     * FIRSTNAME=Jill
     * MIDDLENAME=
     * LASTNAME=Doe
     * EMAIL=jill@doe.com
     * ~
     * FID=2
     * PID=333333333
     * RELATIONS=444444444 father
     * DOB=1/1/1970
     * DOD=12/30/1940
     * FIRSTNAME=John
     * MIDDLENAME=Scott
     * LASTNAME=Doe
     * EMAIL=john@doe.com
     * X
     */
    /*
     * @Ignore
     * 
     * @Test
     * public void testUpdate() {
     * long PID = 111111111;
     * long[] related = { 222222222 };
     * String[] relation = { "tester" };
     * Form tester = new Form(PID, "1/1/2000", "NULL", relation, "First", "Middle",
     * "last", "email@address.com",
     * related);
     * // "Last", "test@gmail.com");
     * DatabaseManager.update(1, tester);
     * Form[] test = DatabaseManager.fetch(1, 1111111111, "", false);
     * Boolean[] fails = test[0].getFail();
     * for (int i = 0; i < 9; i++) {
     * if (fails[i])
     * assertTrue(false);
     * }
     * if (test[0].getPID() != 1111111111)
     * assertTrue(false);
     * if (!(test[0].getRelation()[0].equals("tester")))
     * assertTrue(false);
     * if (!(test[0].getDOB().equals("1/1/2000")))
     * assertTrue(false);
     * if (!(test[0].getDOD().equals("NULL")))
     * assertTrue(false);
     * if (!(test[0].getFirstName().equals("First")))
     * assertTrue(false);
     * if (!(test[0].getMiddleName().equals("Middle")))
     * assertTrue(false);
     * if (!(test[0].getLastName().equals("Last")))
     * assertTrue(false);
     * if (!(test[0].getEmail().equals("email@address.com")))
     * assertTrue(false);
     * if (test[0].getRelatedPID()[0] != 222222222)
     * assertTrue(false);
     * assertTrue(true);
     * }
     */
    /* */
    @Before
    @After
    public void cleanup() {
        try {
            Path replaceMe = Paths.get("Database.txt");
            Path replacement = Paths.get("backup/Database.txt");
            Files.copy(replacement, replaceMe, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            System.err.println("manual database replacement required");
        }
    }
}
