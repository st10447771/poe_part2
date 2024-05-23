/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poe;

/**
 *
 * @author ST10447771
 */

import java.util.Scanner;

public class registerUsers {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to User Registration");           
                 
            while (true) {
                System.out.println("\nEnter username (max 5 characters, must contain underscore): ");
                String username = checkUsername(scanner);
                
                System.out.println("\nEnter a password (min 8 characters, must contain one capital letter, one number, and one special character): ");
                String password = checkPasswordComplexity(scanner);
                
                System.out.println("\nEnter your first name:");
                String firstName = scanner.nextLine();
                
                System.out.println("\nEnter your last name:");
                String lastName = scanner.nextLine();
                
                
                //Store user information in the database
                userDataBase.main(username, password, firstName, lastName);
                
                //Code Attribution
                //This method was taken from stackoverflow
                //https://stackoverflow.com/questions/36709433/i-dont-exactly-know-how-equalsignorecase-work
                //Anakin771
                //https://stackoverflow.com/users/6222879/anakin771
                
                System.out.println("\nRegistered successfully! Do you wish to login? (yes/no)");
                String choice = scanner.nextLine();
                if (!choice.equalsIgnoreCase("yes")) {
                    logInUsers.main(null); //Links to the login file
                    break;
                }
            }          
        }
    }

    // Method to get a valid username
    public static String checkUsername(Scanner scanner) {
        String username = null;
        boolean isValidUsername = false;
        while (!isValidUsername) {
            System.out.print("Enter username (max 5 characters, must contain underscore): ");
            username = scanner.nextLine();
            
            //Code Attribution
            //This method was taken fom stackoveflow
            //https://stackoverflow.com/questions/63234607/how-can-i-validate-the-username-in-a-textbook-field-in-java
            //Kasalwe
            //https://stackoverflow.com/users/1013657/kasalwe
            
            if (isValidUsername(username)) {
                isValidUsername = true;
            } else {
                System.out.println("Username is not formatted correctly.");
            }
        }
        return username;
    }

    // Method to check if the username is valid
    public static boolean isValidUsername(String username) {
        return username.length() <= 5 && username.contains("_");
    }

    // Method to get a valid password
    public static String checkPasswordComplexity(Scanner scanner) {
        String password = null;
        boolean isPasswordValid = false;
        while (!isPasswordValid) {
            System.out.println("Enter password: ");
            password = scanner.nextLine();
            if (isPasswordValid(password)) {
                isPasswordValid = true;
            } else {
                System.out.println("Password is not formatted correctly.");
            }
        }
        return password;
    }

    // Method to check if the password is valid
    public static boolean isPasswordValid(String password) {
        return password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*\\d.*") && password.matches(".*[^A-Za-z0-9].*");
    }
}
   