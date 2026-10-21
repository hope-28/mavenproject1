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
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < 10; i++) {
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
        String first = words.length > 0 ? words[0].toUpperCase() : "";
        String last = words.length > 1 ? words[words.length - 1].toUpperCase() : "";
        String idPart = messageID.length() >= 2 ? messageID.substring(0, 2) : "00";
        return idPart + ":" + message.length() + ":" + first + last;
    }

    public String getMessageID() {
        return messageID;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessage() {
        return message;
    }

    public String getMessageHash() {
        return messageHash;
    }

    public String sendMessage() {
        return JOptionPane.showInputDialog("Choose option:\n1. Send Message\n2. Disregard Message\n3. Store Message to send later");
    }

    public String printMessage() {
        return "Message ID: " + messageID + "\nMessage Hash: " + messageHash + "\nRecipient: " + recipient + "\nMessage: " + message;
    }
}
