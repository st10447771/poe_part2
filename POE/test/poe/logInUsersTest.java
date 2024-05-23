/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package poe;

import javax.swing.JOptionPane;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ST10447771
 */

public class logInUsersTest {

    @Mock
    private userDataBase userDataBase;

    @Mock
    private easyKanbanTasks easyKanbanTasks;

    @InjectMocks
    private logInUsers logInUsers;

    @BeforeEach
    public void setUp() {
        // Mock JOptionPane input dialogs
        mockStatic(JOptionPane.class);
    }

    @Test
    public void testSuccessfulLogin() {
        when(JOptionPane.showInputDialog(null, "Enter your Username:")).thenReturn("validUser");
        when(JOptionPane.showInputDialog(null, "Enter your password:")).thenReturn("validPassword");
        when(userDataBase.authenticate("validUser", "validPassword")).thenReturn(true);

        logInUsers.main(null);

        verify(userDataBase, times(1)).authenticate("validUser", "validPassword");
        verifyStatic(JOptionPane.class, times(1));
        JOptionPane.showInputDialog(null, "Login Successful!");
        verify(easyKanbanTasks, times(1)).manageTasks(null);
    }

    @Test
    public void testUnsuccessfulLogin() {
        when(JOptionPane.showInputDialog(null, "Enter your Username:")).thenReturn("invalidUser");
        when(JOptionPane.showInputDialog(null, "Enter your password:")).thenReturn("invalidPassword");
        when(userDataBase.authenticate("invalidUser", "invalidPassword")).thenReturn(false);

        logInUsers.main(null);

        verify(userDataBase, times(1)).authenticate("invalidUser", "invalidPassword");
        verifyStatic(JOptionPane.class, times(1));
        JOptionPane.showInputDialog(null, "Invalid username or password. Please try again.");
    }

    private Object when(String showInputDialog) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}