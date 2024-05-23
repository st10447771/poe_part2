/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package poe;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 *
 * @author ST10447771
 */
@ExtendWith(MockitoExtension.class)
public class registerUsersTest {

    @Mock
    private userDataBase userDataBase;

    @InjectMocks
    private registerUsers registerUsers;

    private InputStream originalSystemIn;

    @BeforeEach
    public void setUp() {
        originalSystemIn = System.in;
    }

    @Test
    public void testCheckUsername_Valid() {
        String input = "user_";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);

        String username = registerUsers.checkUsername(scanner);

        assertEquals("user_",  username);
    }

    @Test
    public void testCheckUsername_Invalid() {
        String input = "user\nuser_";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);

        String username = registerUsers.checkUsername(scanner);

        assertEquals("user_",  username);
    }

    @Test
    public void testCheckPasswordComplexity_Valid() {
        String input = "Password1!";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);

        String password = registerUsers.checkPasswordComplexity(scanner);

        assertEquals("Password1!",  password);
    }

    @Test
    public void testCheckPasswordComplexity_Invalid() {
        String input = "pass\nPassword1!";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);

        String password = registerUsers.checkPasswordComplexity(scanner);

        assertEquals("Password1!",  password);
    }

    @Test
    public void testIsValidUsername() {
        assertTrue(registerUsers.isValidUsername("user_"));
        assertFalse(registerUsers.isValidUsername("user"));
        assertFalse(registerUsers.isValidUsername("user__"));
        assertFalse(registerUsers.isValidUsername("user_123"));
    }

    @Test
    public void testIsPasswordValid() {
        assertTrue(registerUsers.isPasswordValid("Password1!"));
        assertFalse(registerUsers.isPasswordValid("password"));
        assertFalse(registerUsers.isPasswordValid("Password"));
        assertFalse(registerUsers.isPasswordValid("Password1"));
    }

    @AfterEach
    public void restoreSystemIn() {
        System.setIn(originalSystemIn);
    }
}


