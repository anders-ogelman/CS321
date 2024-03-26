package com.SWEPJ;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
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
        form = new Form(PID, "1/1/2000", "mother", "First", "Middle", "Last", "test@gmail.com");
    }

    @Test
    public void testInitalizePID() {
        if (form.getPID() == 111111111)
            assertTrue(true);
        else
            assertTrue(false);
    }

    @Test
    public void testInitalizeDOB() {
        if (form.getDOB().equals("1/1/2000"))
            assertTrue(true);
        else
            assertTrue(false);
    }

    @Test
    public void testInitalizeRelation() {
        if (form.getRelation().equals("mother"))
            assertTrue(true);
        else
            assertTrue(false);
    }

    @Test
    public void testInitalizeFirstName() {
        if (form.getFirstName().equals("First"))
            assertTrue(true);
        else
            assertTrue(false);
    }

    @Test
    public void testInitalizeMiddleName() {
        if (form.getMiddleName().equals("Middle"))
            assertTrue(true);
        else
            assertTrue(false);
    }

    @Test
    public void testInitalizeLastName() {
        if (form.getLastName().equals("Last"))
            assertTrue(true);
        else
            assertTrue(false);
    }

    @Test
    public void testInitalizeEmail() {
        if (form.getEmail().equals("test@gmail.com"))
            assertTrue(true);
        else
            assertTrue(false);
    }

    @Test
    public void testSetPID() {
        long test = 222222222;
        form.setPID(test);
        if (form.getPID() == 222222222)
            assertTrue(true);
        else
            assertTrue(false);
    }

    @Test
    public void testSetDOB() {
        form.setDOB("2/2/2000");
        if (form.getDOB().equals("2/2/2000"))
            assertTrue(true);
        else
            assertTrue(false);
    }

    @Test
    public void testSetRelation() {
        form.setRelation("father");
        if (form.getRelation().equals("father"))
            assertTrue(true);
        else
            assertTrue(false);
    }

    @Test
    public void testSetFirstName() {
        form.setFirstName("Name1");
        if (form.getFirstName().equals("Name1"))
            assertTrue(true);
        else
            assertTrue(false);
    }

    @Test
    public void testSetMiddleName() {
        form.setMiddleName("Name2");
        if (form.getMiddleName().equals("Name2"))
            assertTrue(true);
        else
            assertTrue(false);
    }

    @Test
    public void testSetLastName() {
        form.setLastName("Name3");
        if (form.getLastName().equals("Name3"))
            assertTrue(true);
        else
            assertTrue(false);
    }

    @Test
    public void testSetEmail() {
        form.setEmail("tester@gmail.com");
        if (form.getEmail().equals("tester@gmail.com"))
            assertTrue(true);
        else
            assertTrue(false);
    }

    

}
