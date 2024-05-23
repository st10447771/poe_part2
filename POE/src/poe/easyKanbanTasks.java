/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poe;

/**
 *
 * @author ST10447771
 */
import javax.swing.JOptionPane;

public class easyKanbanTasks {
    public static void main(String[] args){
        String username = null;
        while(true){
            String[] options = {"Add Tasks", "View Tasks", "Report", "Log Out"};
            int choice = JOptionPane.showOptionDialog(null, "Choose an option", "Task Manager", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            
            
            //Code Attribution
            //This method was taken from stackoverslow
            //https://stackoverflow.com/questions/42729265/how-to-bring-a-code-back-to-the-main-menu
            //nbzimm365, HDJEMAI
            //https://stackoverflow.com/users/5377805/hdjemai 
            
            switch(choice){
                case 0 -> //Add Task
                    createTask(username);
                case 1 -> //View Task
                    taskDetails(username);
                case 2 -> //Report
                    viewReport();
                case 3 -> {
                    // Log Out
                    JOptionPane.showMessageDialog(null, "Logged out successfully!");
                    return; //Exit EasyKanban
                }
                        }
                    }
                }
    private static void createTask(String username){
        String[][] tasks = userDataBase.getTasks(username);
                int taskCount = 0;
                for (String[] task : tasks){
                    if (task[0] != null){
                        taskCount++;
                    }
                }
            if (taskCount >=3){
                JOptionPane.showMessageDialog(null, "You have reached the limit of 3 tasks!");
            }
            else {
                String taskName = JOptionPane.showInputDialog(null, "Enter Task Name.");
                if (taskName == null) return;
                
                String taskDescription = JOptionPane.showInputDialog(null, "Enter the a short description:");
                if (taskDescription == null) return;
            
            String[] statusOptions = {"To Do", "Doing", "Done"};
                String taskStatus = (String) JOptionPane.showInputDialog(null, "Select task status:", "Task Status", JOptionPane.QUESTION_MESSAGE, null, statusOptions, statusOptions[0]);
                if (taskStatus == null) return;
                
            String developerDetails = JOptionPane.showInputDialog(null, "Enter Developer Name and Surname:");
                if (developerDetails == null) return;
                
            String durationHours = JOptionPane.showInputDialog(null, "Enter the duration of the task:");
                if (durationHours == null) return;
             
            userDataBase.addTask(username, taskName, taskStatus, developerDetails, durationHours, taskStatus);
            JOptionPane.showMessageDialog(null, "Task Successfully Captured!");
            }
    }
    
    //Code Attribution
            //This method was taken from stackoverslow
            //https://stackoverflow.com/questions/35399293/make-a-task-list-using-java-to-add-edit-remove-or-exit-from-the-program-using
            //mvanderk10, Andrew Regan 
            //https://stackoverflow.com/users/5927565/mvanderk10
    
    //Code Attribution
            //This method was taken from stackoverslow
            //https://stackoverflow.com/questions/448320/how-do-i-append-a-newline-character-for-all-lines-except-the-last-one
            //Aditya Vikas Devarapalli
            //https://stackoverflow.com/users/2498327/aditya-vikas-devarapalli
    
    private static void taskDetails(String username){
        String [][] tasks = userDataBase.getTasks(username);
            StringBuilder taskList = new StringBuilder("Your Tasks:\n");
                for (int i = 0; i <= 3; i++){
                    if (tasks[i][0] != null){
                        taskList.append((i + 1)).append(".  ");
                        
                        taskList.append("   Task Name:").append(tasks[i][0]).append("\n")
                        .append("   Task Description: ").append(tasks[i][1]).append("\n")
                        .append("   Developer Details: ").append(tasks[i][2]).append("\n")
                        .append("   Duration: ").append(tasks[i][3]).append("\n")
                        .append("   TaskID: ").append(tasks[i][5]).append("\n")
                        .append("   Status: ").append(tasks[i][4]).append("\n");
                    }
                }
                JOptionPane.showMessageDialog(null, taskList.toString());
    }   
    
    private static void viewReport(){
        JOptionPane.showMessageDialog(null, "Coming Soon!");
    }
    
}
