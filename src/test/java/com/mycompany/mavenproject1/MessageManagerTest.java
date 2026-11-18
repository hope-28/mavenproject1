package com.mycompany.mavenproject1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageManagerTest {

    @Test
    public void testSentMessagesArrayCorrectlyPopulated() {
        MessageManager mm = new MessageManager();
        mm.populateTestData();
        // Should contain Message 1 and Message 4
        assertTrue(mm.sentMessages.contains("Did you get the cake?"));
        assertTrue(mm.sentMessages.contains("It is dinner time!"));
        assertEquals(3, mm.sentMessages.size()); // 1, 4, 5
    }

    @Test
    public void testDisplayLongestMessage() {
        MessageManager mm = new MessageManager();
        mm.populateTestData();
        assertEquals("Where are you? You are late! I have asked you to be on time.", mm.displayLongestMessage());
    }

    @Test
    public void testSearchForMessageID() {
        MessageManager mm = new MessageManager();
        mm.populateTestData();
        // Message 4 ID is 0838884567
        assertEquals("It is dinner time!", mm.searchByMessageID("0838884567"));
    }

    @Test
    public void testSearchByRecipient() {
        MessageManager mm = new MessageManager();
        mm.populateTestData();
        String result = mm.searchByRecipient("+27838884567");
        assertTrue(result.contains("Where are you? You are late! I have asked you to be on time."));
        assertTrue(result.contains("Ok, I am leaving without you."));
    }

    @Test
    public void testDeleteByHash() {
        MessageManager mm = new MessageManager();
        mm.populateTestData();
        // Message 2 hash is 00:1: WHERE ARE YOU?
        String result = mm.deleteByHash("00:1: WHERE ARE YOU?");
        assertEquals("Message: \"Where are you? You are late! I have asked you to be on time.\" successfully deleted.", result);
    }

    @Test
    public void testDisplayReport() {
        MessageManager mm = new MessageManager();
        mm.populateTestData();
        String report = mm.displayReport();
        assertTrue(report.contains("Message Hash"));
        assertTrue(report.contains("Recipient"));
        assertTrue(report.contains("Did you get the cake?"));
    }
}
    