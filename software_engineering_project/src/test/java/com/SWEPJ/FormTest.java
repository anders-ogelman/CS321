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
        form = new Form(1, "1/1/1111", "mother", "First", "Middle", "Last");
    }

    @Test
    public void testInitalizePID() {
        if (form.getPID() == 1)
            assertTrue(true);
        else
            assertTrue(false);
    }

    @Test
    public void testInitalizeDOB() {
        if (form.getDOB().equals("1/1/1111"))
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
    public void testSetPID() {
        form.setPID(2);
        if (form.getPID() == 2)
            assertTrue(true);
        else
            assertTrue(false);
    }

    @Test
    public void testSetDOB() {
        form.setDOB("2/2/2222");
        if (form.getDOB().equals("2/2/2222"))
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

}
