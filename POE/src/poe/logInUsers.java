/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poe;

/**
 *
 * @author ST10447771
 */
import javax.swing.JOptionPane;
public class logInUsers {
    public static void main(String[] args){
      
      boolean isLoggedIn= false;
      
      while (!isLoggedIn){
          String username = JOptionPane.showInputDialog(null,"Enter your Username:");
          String password = JOptionPane.showInputDialog(null,"Enter your password:");
          
          //Check if values enteres match any registered users
          if (userDataBase.authenticate(username, password))
              
          if(isLoggedIn){
             JOptionPane.showInputDialog(null,"Login Successful!");
             easyKanbanTasks.main(null);
          }
          else{
              JOptionPane.showInputDialog(null,"Invalid username or password. Please try again.");
          }
      }
        
    }
}
