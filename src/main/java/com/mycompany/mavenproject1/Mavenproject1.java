package com.mycompany.mavenproject1;

import javax.swing.JOptionPane;

public class Mavenproject1 {

    public static void main(String[] args) {
        
        // Part 1 - Registration
        String username = JOptionPane.showInputDialog("Enter username:");
        String password = JOptionPane.showInputDialog("Enter password:");
        String firstName = JOptionPane.showInputDialog("Enter first name:");
        String lastName = JOptionPane.showInputDialog("Enter last name:");
        String cellphone = JOptionPane.showInputDialog("Enter cellphone number with international code (e.g. +27...):");
        
        RegisterUser user = new RegisterUser(username, password, firstName, lastName, cellphone);
        
        // This method from YOUR file does all 3 checks inside itself
        String registrationResult = user.registerUser();
        JOptionPane.showMessageDialog(null, registrationResult);
        
        if (!registrationResult.equals("User has been registered successfully.")) {
            return;
        }
        
        // Part 2 - Login
        String loginUsername = JOptionPane.showInputDialog("Login - Enter username:");
        String loginPassword = JOptionPane.showInputDialog("Login - Enter password:");
        
        JOptionPane.showMessageDialog(null, user.returnLoginStatus(loginUsername, loginPassword));
        
        if (!user.loginUser(loginUsername, loginPassword)) {
            return;
        }
        
        // Part 3 - Messaging
        JOptionPane.showMessageDialog(null, "Welcome to QuickChat");
        
        String numMessagesStr = JOptionPane.showInputDialog("How many messages do you wish to enter?");
        int numMessages = Integer.parseInt(numMessagesStr);
        int sentCount = 0;
        
        for (int i = 0; i < numMessages; i++) {
            String recipient = JOptionPane.showInputDialog("Enter recipient cell number (must start with +27 and be 12 characters):");
            String messageText = JOptionPane.showInputDialog("Enter your message (max 250 characters):");
            
            if (messageText.length() > 250) {
                JOptionPane.showMessageDialog(null, "Please enter a message of less than 250 characters");
                i--;
                continue;
            }
            
            Message msg = new Message(recipient, messageText);
            
            if (msg.checkRecipientCell() == 0) {
                JOptionPane.showMessageDialog(null, "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.");
                i--;
                continue;
            }
            
            String option = JOptionPane.showInputDialog("Choose an option:\n1. Send Message\n2. Disregard Message\n3. Store Message to send later");
            
            if (option.equals("1")) {
                JOptionPane.showMessageDialog(null, msg.printMessage());
                sentCount++;
            } else if (option.equals("2")) {
                JOptionPane.showMessageDialog(null, "Press 0 to delete message.");
            } else if (option.equals("3")) {
                JOptionPane.showMessageDialog(null, "Message successfully stored.");
            }
        }
        
        JOptionPane.showMessageDialog(null, "Total messages sent: " + sentCount);
    }
}