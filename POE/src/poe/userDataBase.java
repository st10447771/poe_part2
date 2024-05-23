/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poe;

import javax.swing.JOptionPane;

/**
 *
 * @author ST10447771
 */
public class userDataBase {
    private static final String[][]
            //Code Attribution
            //This method as taken from stackoverflow
            //https://stackoverflow.com/questions/29618205/counting-an-occurrence-in-an-array-java
            //Brenda Mejia
            //https://stackoverflow.com/users/5254203/brenda-mejia
            
    // Array to store registered user information
            registeredUsers = new String[100][4]; // Assuming the maximum amount of users is 100
            private static int currentIndex = 0; // Index to keep track of the next available slot in the array
            //Use Tasks array has multiple attributes 
            private static final String[][][] userTasks = new String[100][3][5];
                               
            //Method to add user to the database
    public static void main(String username, String password, String firstName, String lastName){
        
                registeredUsers[currentIndex][0] = username;
                registeredUsers[currentIndex][1] = password;
                registeredUsers[currentIndex][2] = firstName;
                registeredUsers[currentIndex][3] = lastName;
                
                currentIndex++; // Move to the next available slot
                }
    
    //Code Attribution
            //This method as taken from stackoverflow
            //https://stackoverflow.com/questions/28095083/java-username-and-password-always-returns-true
            //Peter F
            //https://stackoverflow.com/users/2423419/peter-f
            
    //Method to check if a user eists with the given username and password
        public static boolean authenticate(String username, String password){
            for (int i = 0; i < currentIndex; i++){
              return registeredUsers[i][0].equals(username) && registeredUsers[i][1].equals(password);  
            }
        return true;
        }
    
    //Method to get the current registered users
    public static String[][] getRegisteredUsers(){
        return registeredUsers;
    } 
    
    //Method to get the curent index
    public static int getCurrentIndex(){
    return currentIndex;
    }
    
    public static void addTask(String username, String taskName, String taskDescription, String developerDetails, String durationHours, String taskStatus){
        int userIndex = getUserIndex(username);
            if (userIndex != -1){
                for (int i = 0; i <= 3; i++){
                    if(userTasks[userIndex][i][0] == null){
                       userTasks[userIndex][i][0] = taskName;
                       userTasks[userIndex][i][1] = taskDescription;
                       userTasks[userIndex][i][2] = developerDetails;
                       userTasks[userIndex][i][3] = durationHours;
                       userTasks[userIndex][i][4] = taskStatus;
                       String taskID = createTaskID(taskName, i +1, developerDetails);
                       userTasks[userIndex][i][5] = taskID;

                       break;
                    }
                }
            }
        }
    //Code Attribution
            //This method as taken from stackoverflow
            //https://stackoverflow.com/questions/19960458/comparing-two-arrays-for-login-form
            //ApproachingDarknessFish
            //https://stackoverflow.com/users/1530508/approachingdarknessfish
            
    public static String[][] getTasks(String username){
        int userIndex = getUserIndex(username);
        if (userIndex != -1) {
            return userTasks[userIndex];
        }
        return null;
    }
    
    public static int getUserIndex(String username){
        for (int i = 0; i < currentIndex; i++){
            
            //Code Attribution
            //This method was taken from stackoverslow
            //https://stackoverflow.com/questions/10438382/java-tcp-clients-servers-and-loop-issues
            //eabraham, user1373440
            //https://stackoverflow.com/posts/10438382/revisions
            
            if (registeredUsers[i][0].equals(username)){
                return i;
            }
        }
        return -1;
    }
    
    //Code Attribution
            //This method as taken from stackoverflow
            //https://stackoverflow.com/questions/41954035/java-touppercase-method-is-undefined-for-type-string
            //root
            //https://stackoverflow.com/users/762395/root
    private static String createTaskID(String taskName, int taskNumber, String developerDetails){
        String taskID = taskName.substring(0, 2).toUpperCase()+ ":" + taskNumber + ":" + developerDetails.substring(developerDetails.length()-3).toUpperCase();
        return taskID;
    }
    
    public static boolean checkTaskDescription(String taskDescription){
        if (taskDescription.length() > 50){
            JOptionPane.showMessageDialog(null, "Please enter a task description less than 50 characters.");
        }
        return taskDescription.length() <= 50;
    }
    
    //Code Attribution
    //This method was taken from BRAINLY
    //https://brainly.com/app/profile/74598699/answers
    //raajratan
    public static int returnTotalHours(String username){
        int userIndex = getUserIndex(username);
            if (userIndex != -1){
                int totalHours = 0;
                for( int i = 0; i <= 3; i++){
                    if (userTasks[userIndex][i][0] != null){
                        try {
                            totalHours += Integer.parseInt(userTasks[userIndex][i][1]);
                        }
                        
            //Code Attribution
            //This method as taken from stackoverflow
            //https://stackoverflow.com/questions/4410107/what-is-the-proper-way-to-handle-a-numberformatexception-when-it-is-expected
            //Erick Robertson
            //https://stackoverflow.com/users/300311/erick-robertson
                        
                        catch (NumberFormatException e){}
                    }
                }
                return totalHours;
            }
            return 0;
    }
    
}
