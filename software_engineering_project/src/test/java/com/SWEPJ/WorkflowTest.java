package com.SWEPJ;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class WorkflowTest {

    // tester for the review and approve stage being able to access the results of
    // the data
    // entry stage

    @Test
    public void testAccess() {

        assertTrue(1 == WorkflowManager.info(1));
        assertTrue(1 == WorkflowManager.info(2));
        assertTrue(2 == WorkflowManager.info(1));
        assertTrue(2 == WorkflowManager.info(2));

        assertTrue(null == WorkflowManager.info(1));
        assertTrue(null == WorkflowManager.info(2));
    }

    // tester for approval step being able to access the results of the review stage

    @Test
    public void testEntryPush() {
        for (int i = 0; i < 2; i++) {
            WorkflowManager.info(1);
            WorkflowManager.info(2);
        }
        assertTrue(WorkflowManager.info(1) == null);
        assertTrue(null == WorkflowManager.info(2));
        assertTrue(null == WorkflowManager.info(2));
        assertTrue(WorkflowManager.update(0, 1));
        assertTrue(WorkflowManager.update(2, 3));
        assertTrue(WorkflowManager.update(1, 2));
        assertTrue(WorkflowManager.update(1, 4));
        assertTrue(1 == WorkflowManager.info(1));
        assertTrue(2 == WorkflowManager.info(2));
        assertTrue(3 == WorkflowManager.info(1));
        assertTrue(4 == WorkflowManager.info(2));

    }

    // method to reset the workflow text file to its original state after testing,
    // so further testing can be consistent
    // part of this is populating the workflow file with the example requestor's
    // information found throughout these
    // tests
    @Before
    @After
    public void cleanup() {
        try {
            System.out.println("the after thing is running right now");
            Path replaceMe = Paths.get("Workflow.txt");
            Path replacement = Paths.get("backup/Workflow.txt");
            Files.copy(replacement, replaceMe, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            System.err.println("manual workflow replacement required");
            System.err.println(e.getMessage());
        }
    }

}
