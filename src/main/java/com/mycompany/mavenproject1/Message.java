package com.mycompany.mavenproject1;

import javax.swing.JOptionPane;
import java.util.Random;

public class Message {

    private String messageID;
    private String recipient;
    private String message;
    private String messageHash;

    public Message(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
        this.messageID = generateMessageID();
        this.messageHash = createMessageHash();
    }

    private String generateMessageID() {
        Random rand = new Random();
        StringBuilder id = new StringBuilder("00");
        for (int i = 0; i < 8; i++) {
            id.append(rand.nextInt(10));
        }
        return id.toString();
    }

    public boolean checkMessageID() {
        return messageID.length() == 10;
    }

    public int checkRecipientCell() {
        if (recipient.startsWith("+27") && recipient.length() == 12) {
            return 1;
        } else {
            return 0;
        }
    }

    public String createMessageHash() {
        String[] words = message.split(" ");
        String firstLast = (words[0] + words[words.length - 1]).toUpperCase();
        return messageID.substring(0,2) + ":0:" + firstLast;
    }

    public String getMessageID() {
        return messageID;
    }

    public String getRecipient() {
        return recipient;
    }

    
}
