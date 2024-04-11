package com.SWEPJ;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * This class tests the Form class, It checks the getters and setters, which
 * should check if the input is valid before allowing the variable to be set
 */
public class FormTest {

    Form form;

    // This sets up the inital form to be tested
    @Before
    public void setup() {
        long PID = 111111111;
        long[] relatedPID = { 222222222 };
        String[] relation = { "mother" };
        form = new Form(PID, "1/1/2000", "NULL", relation, "First", "Middle", "Last", "test@gmail.com", relatedPID);
    }

    // test the inital fail array, should
    @Test
    public void testInitalizeFail() {
        // should have all passed
        Boolean[] fail = form.getFail();
        for (int i = 0; i < 8; i++) {
            if (fail[i] == true)
                assertTrue(false);
        }
        assertTrue(true);
    }

    // tests inital PID
    @Test
    public void testInitalizePID() {
        assertTrue(form.getPID() == 111111111);
    }

    // test inital related PID
    @Test
    public void testInitalizeRelatedPID() {
        long test = 222222222;
        assertTrue(form.getRelatedPID()[0] == test);
    }

    // test inital DOB
    @Test
    public void testInitalizeDOB() {
        assertTrue(form.getDOB().equals("1/1/2000"));
    }

    // test inital relation array
    @Test
    public void testInitalizeRelation() {
        assertTrue(form.getRelation()[0].equals("mother"));
    }

    // test inital first name
    @Test
    public void testInitalizeFirstName() {
        assertTrue(form.getFirstName().equals("First"));
    }

    // test inital middle name
    @Test
    public void testInitalizeMiddleName() {
        assertTrue(form.getMiddleName().equals("Middle"));
    }

    // test inital last name
    @Test
    public void testInitalizeLastName() {
        assertTrue(form.getLastName().equals("Last"));
    }

    // test inital email
    @Test
    public void testInitalizeEmail() {
        assertTrue(form.getEmail().equals("test@gmail.com"));
    }

    // test inital DOB
    @Test
    public void testInitalizeDOD() {
        assertTrue(form.getDOD().equals("NULL"));
    }

    // test setting pid
    @Test
    public void testSetPID() {
        long test = 222222222;
        assertTrue(form.setPID(test) && form.getPID() == 222222222);
    }

    // test setting dob
    @Test
    public void testSetDOB() {
        assertTrue(form.setDOB("2/2/2000") && form.getDOB().equals("2/2/2000"));
    }

    // test setting relation array
    @Test
    public void testSetRelation() {
        String[] test = { "father" };
        assertTrue(form.setRelation(test) && form.getRelation().equals(test));
    }

    // tests setting relation pid array
    @Test
    public void testSetRelatedPID() {
        long[] test = { 222222222 };
        assertTrue(form.setRelatedPID(test) && form.getRelatedPID().equals(test));
    }

    // tests setting first name
    @Test
    public void testSetFirstName() {
        assertTrue(form.setFirstName("Name1") && form.getFirstName().equals("Name1"));
    }

    // tests setting middle name
    @Test
    public void testSetMiddleName() {
        assertTrue(form.setMiddleName("Name2") && form.getMiddleName().equals("Name2"));
    }

    // tests setting last name
    @Test
    public void testSetLastName() {
        assertTrue(form.setLastName("Name3") && form.getLastName().equals("Name3"));
    }

    // tests setting email
    @Test
    public void testSetEmail() {
        assertTrue(form.setEmail("tester@gmail.com") && form.getEmail().equals("tester@gmail.com"));
    }

    // tests setting DOD
    @Test
    public void testSetDOD() {
        assertTrue(form.setDOD("1/1/2001") && form.getDOD().equals("1/1/2001"));
    }

    // tests setting DOD to null, if person is not dead
    @Test
    public void testSetDODNull() {
        form.setDOD("NULL");
        assertTrue(form.setDOD("NULL") && form.getDOD().equals("NULL"));
    }

    /*
     * The tests below test incorrect inputs, if an input is incorrect, then the
     * fail array will be populated allowing the individual guis to desplay
     * incorrect information. it will also cause the information to not be set
     */

    // tests a pid that is too short (not 9 numbers)
    @Test
    public void testWrongPIDShort() {
        long test = 1;
        boolean test1 = form.setPID(test);
        Boolean[] fail = form.getFail();
        assertFalse(test1 || (!fail[0]));
    }

    // tests a pid that is too long (not 9 numbers)
    @Test
    public void testWrongPIDLong() {
        long test = 1111111111;
        boolean test1 = form.setPID(test);
        Boolean[] fail = form.getFail();
        assertFalse(test1 || (!fail[0]));
    }

    // tests a birthday with a nonexistant month
    @Test
    public void testWrongDOBMonth() {
        boolean test = form.setDOB("13/1/2002");
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[1]));
    }

    // tests a birthday with a nonexistant day
    @Test
    public void testWrongDOBDay() {
        boolean test = form.setDOB("12/0/2002");
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[1]));
    }

    // tests a birthday with a year from too long ago
    @Test
    public void testWrongDOBYear() {
        boolean test = form.setDOB("12/1/1899");
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[1]));
    }

    // tests a death day with a nonexistant month
    @Ignore
    @Test
    public void testWrongDODMonth() {
        boolean test = form.setDOD("13/1/2000");
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[2]));
    }

    // tests a death day with a nonexistant day
    @Ignore
    @Test
    public void testWrongDODDay() {
        boolean test = form.setDOD("12/0/2000");
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[2]));
    }

    // tests a death day with a year that is too long ago
    @Ignore
    @Test
    public void testWrongDODYear() {
        boolean test = form.setDOD("12/1/1899");
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[2]));
    }

    // tests a death day that is before a birthday
    @Ignore
    @Test
    public void testConfictingDOD() {
        boolean test = form.setDOD("12/1/1999");
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[2]));
    }

    // tests a first name that is too long (>35 chars)
    @Test
    public void testWrongFirstNameLong() {
        boolean test = form.setFirstName("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[4]));
    }

    // tests a first name that is too short (<1 char)
    @Test
    public void testWrongFirstNameShort() {
        boolean test = form.setFirstName("");
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[4]));
    }

    // tests a middle name that is too long (>35 chars) (also no middle name is
    // possible, so no short test)
    @Test
    public void testWrongMiddleNameShortLong() {
        boolean test = form.setMiddleName("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[5]));
    }

    // tests a last name that is too long (>35 chars)
    @Test
    public void testWrongLastNameLong() {
        boolean test = form.setLastName("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[6]));
    }

    // tests a last name that is too short (<1 char)
    @Test
    public void testWrongLastNameShort() {
        boolean test = form.setLastName("");
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[6]));
    }

    // tests a relation name that is too long (>35 chars)
    @Ignore
    @Test
    public void testWrongRelationLong() {
        String[] tooLong = { "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" };
        boolean test = form.setRelation(tooLong);
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[2]));
    }

    // tests a relation name that is too short (<1 char)
    @Ignore
    @Test
    public void testWrongEmailShort() {
        boolean test = form.setEmail("");
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[7]));
    }

    // tests an email that is too long (>105 chars)
    @Ignore
    @Test
    public void testWrongEmailLong() {
        String sample = "";
        for (int i = 0; i < 50; i++)
            sample += "A";
        sample += "@";
        for (int i = 0; i < 51; i++)
            sample += "A";
        sample += ".com";
        boolean test = form.setEmail(sample);
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[7]));
    }

    // tests an email that is missing the '@' char
    @Ignore
    @Test
    public void testWrongEmailinvalid1() {
        boolean test = form.setEmail("AAA.com");
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[7]));
    }

    // tests an email that is missing the '.' char
    @Ignore
    @Test
    public void testWrongEmailinvalid2() {
        boolean test = form.setEmail("AAA@AAA");
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[7]));
    }

    // tests a relitives pid that is too short (not 9 numbers)
    @Ignore
    @Test
    public void testWrongRelatedPIDShort() {
        long[] sample = { 1 };
        boolean test = form.setRelatedPID(sample);
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[8]));
    }

    // tests a relitives pid that is too short (not 9 numbers)
    @Ignore
    @Test
    public void testWrongRelatedPIDLong() {
        long[] sample = { 1 };
        boolean test = form.setRelatedPID(sample);
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[8]));
    }

}
