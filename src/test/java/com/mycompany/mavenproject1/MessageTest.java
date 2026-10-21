package com.mycompany.mavenproject1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    @Test
    public void testCheckMessageID_Success() {
        Message msg = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight");
        assertTrue(msg.checkMessageID());
    }

    @Test
    public void testCheckRecipientCell_Success() {
        Message msg = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight");
        assertEquals(1, msg.checkRecipientCell());
    }

    @Test
    public void testCheckRecipientCell_Failure() {
        Message msg = new Message("0857597589", "Hi Mike, can you join us for dinner tonight");
        assertEquals(0, msg.checkRecipientCell());
    }

    @Test
    public void testCreateMessageHash() {
        Message msg = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight");
        String expected = "00:0:HITONIGHT";
        assertEquals(expected, msg.createMessageHash());
    }
}
