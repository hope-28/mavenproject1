package com.mycompany.mavenproject1;

import java.util.ArrayList;

public class MessageManager {
    
    // Arrays for Part 3 - NO hard-coding in main program, we populate here
    public ArrayList<String> sentMessages = new ArrayList<>();
    public ArrayList<String> disregardedMessages = new ArrayList<>();
    public ArrayList<String> storedMessages = new ArrayList<>();
    public ArrayList<String> messageHashes = new ArrayList<>();
    public ArrayList<String> messageIDs = new ArrayList<>();
    public ArrayList<String> recipients = new ArrayList<>();
    public ArrayList<String> allMessages = new ArrayList<>();

    // This populates the arrays with the test data from the POE
    public void populateTestData() {
        addMessage("+27834557896", "Did you get the cake?", "Sent", "00:0: DID YOU GET THE CAKE?", "1234567890");
        addMessage("+27838884567", "Where are you? You are late! I have asked you to be on time.", "Stored", "00:1: WHERE ARE YOU?", "1838884567");
        addMessage("+27834484567", "Yohoooo, I am at your gate.", "Disregard", "00:2: YOHOOOOO I AM", "2234567890");
        addMessage("+27838884567", "It is dinner time!", "Sent", "00:3: IT IS DINNER TIME!", "0838884567");
        addMessage("+27838884567", "Ok, I am leaving without you.", "Sent", "00:4: OK I AM LEAVING", "3234567890");
    }

    public void addMessage(String recipient, String message, String flag, String hash, String id) {
        allMessages.add(message);
        recipients.add(recipient);
        messageHashes.add(hash);
        messageIDs.add(id);
        
        if (flag.equalsIgnoreCase("Sent")) {
            sentMessages.add(message);
        } else if (flag.equalsIgnoreCase("Disregard")) {
            disregardedMessages.add(message);
        } else if (flag.equalsIgnoreCase("Stored")) {
            storedMessages.add(message);
        }
    }

    // a. Display sender and recipient of all stored messages
    public String displayStoredMessages() {
        String result = "";
        for (int i = 0; i < storedMessages.size(); i++) {
            // Find the index in allMessages
            int idx = allMessages.indexOf(storedMessages.get(i));
            result += "Recipient: " + recipients.get(idx) + " - Message: " + storedMessages.get(i) + "\n";
        }
        return result;
    }

    // b. Display the longest stored message
    public String displayLongestMessage() {
        String longest = "";
        for (String msg : allMessages) {
            if (msg.length() > longest.length()) {
                longest = msg;
            }
        }
        return longest;
    }

    // c. Search for a messageID
    public String searchByMessageID(String searchID) {
        for (int i = 0; i < messageIDs.size(); i++) {
            if (messageIDs.get(i).equals(searchID)) {
                return allMessages.get(i);
            }
        }
        return "Message not found";
    }

    // d. Search for all messages for a particular recipient
    public String searchByRecipient(String searchRecipient) {
        String result = "";
        for (int i = 0; i < recipients.size(); i++) {
            if (recipients.get(i).equals(searchRecipient)) {
                result += allMessages.get(i) + "\n";
            }
        }
        if (result.equals("")) {
            return "No messages found";
        }
        return result;
    }

    // e. Delete a message using message hash
    public String deleteByHash(String hashToDelete) {
        for (int i = 0; i < messageHashes.size(); i++) {
            if (messageHashes.get(i).equals(hashToDelete)) {
                String deletedMsg = allMessages.get(i);
                // Remove from all lists
                allMessages.remove(i);
                recipients.remove(i);
                messageHashes.remove(i);
                messageIDs.remove(i);
                // Also remove from sent/stored/disregarded
                sentMessages.remove(deletedMsg);
                storedMessages.remove(deletedMsg);
                disregardedMessages.remove(deletedMsg);
                return "Message: \"" + deletedMsg + "\" successfully deleted.";
            }
        }
        return "Message not found";
    }

    // Display Report
    public String displayReport() {
        String report = "=== MESSAGE REPORT ===\n";
        for (int i = 0; i < allMessages.size(); i++) {
            report += "Message Hash: " + messageHashes.get(i) + "\n";
            report += "Recipient: " + recipients.get(i) + "\n";
            report += "Message: " + allMessages.get(i) + "\n";
            report += "Message ID: " + messageIDs.get(i) + "\n";
            report += "----------------------\n";
        }
        return report;
    }
}
