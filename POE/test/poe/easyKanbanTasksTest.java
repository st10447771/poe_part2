/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package poe;

import javax.swing.JOptionPane;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class easyKanbanTasksTest {

   @Mock
   private userDataBase userDataBase;

   @InjectMocks
   private easyKanbanTasks easyKanbanTasks;

   @BeforeEach
   public void setUp() {
       // Mock JOptionPane input dialogs
       /*mockStatic*/(JOptionPane.class);
   }

   @Test
   public void testManageTasks_AddTask() {
       String username = "testUser";
       String[] options = {"Add Tasks",  "View Tasks",  "Report",  "Log Out"};

       when(JOptionPane.showOptionDialog(null,  "Choose an option",  "Task Manager",  JOptionPane.DEFAULT_OPTION,  JOptionPane.INFORMATION_MESSAGE,  null,  options,  options[0])).thenReturn(0);
       when(userDataBase.getTasks(username)).thenReturn(new String[4][6]);
       when(JOptionPane.showInputDialog(null,  "Enter Task Name.")).thenReturn("Test Task");
       when(JOptionPane.showInputDialog(null,  "Enter the a short description: ")).thenReturn("Test Description");
       when(JOptionPane.showInputDialog(null,  "Select task status: ",  "Task Status",  JOptionPane.QUESTION_MESSAGE,  null,  new String[]{"To Do",  "Doing",  "Done"},  "To Do")).thenReturn("To Do");
       when(JOptionPane.showInputDialog(null,  "Enter Developer Name and Surname: ")).thenReturn("Developer Name");
       when(JOptionPane.showInputDialog(null,  "Enter the duration of the task: ")).thenReturn("5 hours");

       easyKanbanTasks.manageTasks(username);

       verifyStatic(JOptionPane.class);
       JOptionPane.showOptionDialog(null,  "Choose an option",  "Task Manager",  JOptionPane.DEFAULT_OPTION,  JOptionPane.INFORMATION_MESSAGE,  null,  options,  options[0]);
       verify(userDataBase,  times(1)).getTasks(username);
       verify(userDataBase,  times(1)).addTask(username,  "Test Task",  "To Do",  "Developer Name",  "5 hours",  "To Do");
       verifyStatic(JOptionPane.class);
       JOptionPane.showMessageDialog(null,  "Task Successfully Captured!");
   }

   @Test
   public void testManageTasks_ViewTask() {
       String username = "testUser";
       String[] options = {"Add Tasks",  "View Tasks",  "Report",  "Log Out"};
       String[][] tasks = {
               {"Task1",  "Description1",  "Dev1",  "5 hours",  "To Do",  "ID1"}, 
               {"Task2",  "Description2",  "Dev2",  "3 hours",  "Doing",  "ID2"}, 
               {"Task3",  "Description3",  "Dev3",  "2 hours",  "Done",  "ID3"}, 
               {null,  null,  null,  null,  null,  null}
       };

       when(JOptionPane.showOptionDialog(null,  "Choose an option",  "Task Manager",  JOptionPane.DEFAULT_OPTION,  JOptionPane.INFORMATION_MESSAGE,  null,  options,  options[0])).thenReturn(1);
       when(userDataBase.getTasks(username)).thenReturn(tasks);

       easyKanbanTasks.manageTasks(username);

       verifyStatic(JOptionPane.class);
       JOptionPane.showOptionDialog(null,  "Choose an option",  "Task Manager",  JOptionPane.DEFAULT_OPTION,  JOptionPane.INFORMATION_MESSAGE,  null,  options,  options[0]);
       verify(userDataBase,  times(1)).getTasks(username);

       StringBuilder expectedTasks = new StringBuilder("Your Tasks: \n");
       for (int i = 0; i < tasks.length - 1; i++) {
           expectedTasks.append((i + 1)).append(".  ")
                   .append("   Task Name: ").append(tasks[i][0]).append("\n")
                   .append("   Task Description:  ").append(tasks[i][1]).append("\n")
                   .append("   Developer Details:  ").append(tasks[i][2]).append("\n")
                   .append("   Duration:  ").append(tasks[i][3]).append("\n")
                   .append("   TaskID:  ").append(tasks[i][5]).append("\n")
                   .append("   Status:  ").append(tasks[i][4]).append("\n");
       }

       verifyStatic(JOptionPane.class);
       JOptionPane.showMessageDialog(null,  expectedTasks.toString());
   }

   @Test
   public void testManageTasks_Report() {
       String username = "testUser";
       String[] options = {"Add Tasks",  "View Tasks",  "Report",  "Log Out"};

       when(JOptionPane.showOptionDialog(null,  "Choose an option",  "Task Manager",  JOptionPane.DEFAULT_OPTION,  JOptionPane.INFORMATION_MESSAGE,  null,  options,  options[0])).thenReturn(2);

       easyKanbanTasks.manageTasks(username);

       verifyStatic(JOptionPane.class);
       JOptionPane.showOptionDialog(null,  "Choose an option",  "Task Manager",  JOptionPane.DEFAULT_OPTION,  JOptionPane.INFORMATION_MESSAGE,  null,  options,  options[0]);
       verifyStatic(JOptionPane.class);
       JOptionPane.showMessageDialog(null,  "Coming Soon!");
   }

   @Test
   public void testManageTasks_LogOut() {
       String username = "testUser";
       String[] options = {"Add Tasks",  "View Tasks",  "Report",  "Log Out"};

       when(JOptionPane.showOptionDialog(null,  "Choose an option",  "Task Manager",  JOptionPane.DEFAULT_OPTION,  JOptionPane.INFORMATION_MESSAGE,  null,  options,  options[0])).thenReturn(3);

       easyKanbanTasks.manageTasks(username);

       verifyStatic(JOptionPane.class);
       JOptionPane.showOptionDialog(null,  "Choose an option",  "Task Manager",  JOptionPane.DEFAULT_OPTION,  JOptionPane.INFORMATION_MESSAGE,  null,  options,  options[0]);
       verifyStatic(JOptionPane.class);
       JOptionPane.showMessageDialog(null,  "Logged out successfully!");
   }
}
