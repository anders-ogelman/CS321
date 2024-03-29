package com.SWEPJ;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class FormTest {
    /**
     * Rigorous Test :-)
     */
    Form form;

    @Before
    public void setup() {
        long PID = 111111111;
        long[] relatedPID = { 222222222 };
        String[] relation = { "mother" };
        form = new Form(PID, "1/1/2000", "NULL", relation, "First", "Middle", "Last", "test@gmail.com", relatedPID);
    }

    @Test
    public void testInitalizeFail() {
        Boolean[] fail = form.getFail();
        for (int i = 0; i < 8; i++) {
            if (fail[i] == true)
                assertTrue(false);
        }
        assertTrue(true);
    }

    @Test
    public void testInitalizePID() {
        assertTrue(form.getPID() == 111111111);
    }

    @Test
    public void testInitalizeRelatedPID() {
        long test = 222222222;
        assertTrue(form.getRelatedPID()[0] == test);
    }

    @Test
    public void testInitalizeDOB() {
        assertTrue(form.getDOB().equals("1/1/2000"));
    }

    @Test
    public void testInitalizeRelation() {
        assertTrue(form.getRelation()[0].equals("mother"));
    }

    @Test
    public void testInitalizeFirstName() {
        assertTrue(form.getFirstName().equals("First"));
    }

    @Test
    public void testInitalizeMiddleName() {
        assertTrue(form.getMiddleName().equals("Middle"));
    }

    @Test
    public void testInitalizeLastName() {
        assertTrue(form.getLastName().equals("Last"));
    }

    @Test
    public void testInitalizeEmail() {
        assertTrue(form.getEmail().equals("test@gmail.com"));
    }

    @Test
    public void testInitalizeDOD() {
        assertTrue(form.getDOD().equals("NULL"));
    }

    @Test
    public void testSetPID() {
        long test = 222222222;
        assertTrue(form.setPID(test) && form.getPID() == 222222222);
    }

    @Test
    public void testSetDOB() {
        assertTrue(form.setDOB("2/2/2000") && form.getDOB().equals("2/2/2000"));
    }

    @Test
    public void testSetRelation() {
        String[] test = { "father" };
        assertTrue(form.setRelation(test) && form.getRelation().equals(test));
    }

    @Test
    public void testSetRelatedPID() {
        long[] test = { 222222222 };
        assertTrue(form.setRelatedPID(test) && form.getRelatedPID().equals(test));
    }

    @Test
    public void testSetFirstName() {
        assertTrue(form.setFirstName("Name1") && form.getFirstName().equals("Name1"));
    }

    @Test
    public void testSetMiddleName() {
        assertTrue(form.setMiddleName("Name2") && form.getMiddleName().equals("Name2"));
    }

    @Test
    public void testSetLastName() {
        assertTrue(form.setLastName("Name3") && form.getLastName().equals("Name3"));
    }

    @Test
    public void testSetEmail() {
        assertTrue(form.setEmail("tester@gmail.com") && form.getEmail().equals("tester@gmail.com"));
    }

    @Test
    public void testSetDOD() {
        assertTrue(form.setDOD("1/1/2001") && form.getDOD().equals("1/1/2001"));
    }

    @Test
    public void testSetDODNull() {
        form.setDOD("NULL");
        assertTrue(form.setDOD("NULL") && form.getDOD().equals("NULL"));
    }

    @Test
    public void testWrongPID1() {
        long test = 1;
        boolean test1 = form.setPID(test);
        Boolean[] fail = form.getFail();
        assertFalse(test1 || (!fail[0]));
    }

    @Test
    public void testWrongPID2() {
        long test = 1111111111;
        boolean test1 = form.setPID(test);
        Boolean[] fail = form.getFail();
        assertFalse(test1 || (!fail[0]));
    }

    @Test
    public void testWrongDOBMonth() {
        boolean test = form.setDOB("13/1/2002");
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[1]));
    }

    @Test
    public void testWrongDOBDay() {
        boolean test = form.setDOB("12/0/2002");
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[1]));
    }

    @Test
    public void testWrongDOBYear() {
        boolean test = form.setDOB("12/1/1899");
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[1]));
    }

    @Ignore
    @Test
    public void testWrongDODMonth() {
        boolean test = form.setDOD("13/1/2000");
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[2]));
    }

    @Ignore
    @Test
    public void testWrongDODDay() {
        boolean test = form.setDOD("12/0/2000");
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[2]));
    }

    @Ignore
    @Test
    public void testWrongDODYear() {
        boolean test = form.setDOD("12/1/1899");
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[2]));
    }

    @Ignore
    @Test
    public void testConfictingDOD() {
        boolean test = form.setDOD("12/1/1999");
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[2]));
    }

    @Test
    public void testWrongFirstNameLong() {
        boolean test = form.setFirstName("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[4]));
    }

    @Test
    public void testWrongFirstNameShort() {
        boolean test = form.setFirstName("");
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[4]));
    }

    @Test
    public void testWrongMiddleNameShortLong() {
        boolean test = form.setMiddleName("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[5]));
    }

    @Test
    public void testWrongLastNameLong() {
        boolean test = form.setLastName("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[6]));
    }

    @Test
    public void testWrongLastNameShort() {
        boolean test = form.setLastName("");
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[6]));
    }

    @Ignore
    @Test
    public void testWrongRelationLong() {
        String[] tooLong = { "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" };
        boolean test = form.setRelation(tooLong);
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[2]));
    }

    @Ignore
    @Test
    public void testWrongEmailShort() {
        boolean test = form.setEmail("");
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[7]));
    }

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

    @Ignore
    @Test
    public void testWrongEmailinvalid1() {
        boolean test = form.setEmail("AAA.com");
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[7]));
    }

    @Ignore
    @Test
    public void testWrongEmailinvalid2() {
        boolean test = form.setEmail("AAA@AAA");
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[7]));
    }

    @Ignore
    @Test
    public void testWrongRelatedPIDShort() {
        long[] sample = { 1 };
        boolean test = form.setRelatedPID(sample);
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[8]));
    }

    @Ignore
    @Test
    public void testWrongRelatedPIDLong() {
        long[] sample = { 1 };
        boolean test = form.setRelatedPID(sample);
        Boolean[] fail = form.getFail();
        assertFalse(test || (!fail[8]));
    }

}
