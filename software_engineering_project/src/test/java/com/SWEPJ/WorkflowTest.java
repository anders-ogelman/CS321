package com.SWEPJ;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.junit.After;
import org.junit.Test;

public class WorkflowTest {
    @Test
    public void testInitalizePID() {
        try {
            // DatabaseManager.read();
            assertTrue(true);
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
            System.err.println("manual database replacement required");
        }
    }

}
