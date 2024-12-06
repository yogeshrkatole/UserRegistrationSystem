package test.java;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import main.java.UserRegistrationClass;
import main.java.UserRegistrationException;

public class UserRegistrationClassTest {

    @Test
    public void testFirstName_valid_returnHappy() {
        try {
            assertTrue(UserRegistrationClass.checkFirstOrLastName("Yogesh"));
        } catch (UserRegistrationException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testFirstName_invalid_throwsException() {
        try {
            UserRegistrationClass.checkFirstOrLastName("yogesh");
            fail("Expected UserRegistrationException was not thrown");
        } catch (UserRegistrationException e) {
        	assertEquals("Invalid Name: Start with a capital letter and contains at least 3 characters.", e.getMessage());
        }
    }


    @Test
    public void testLastName_valid_returnHappy() {
        try {
            assertTrue(UserRegistrationClass.checkFirstOrLastName("Katole"));
        } catch (UserRegistrationException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testLastName_invalid_throwsException() {
        try {
            UserRegistrationClass.checkFirstOrLastName("katole");
            fail("Expected UserRegistrationException was not thrown");
        } catch (UserRegistrationException e) {
        	assertEquals("Invalid Name: Start with a capital letter and contains at least 3 characters.", e.getMessage());
        }
    }

    @Test
    public void testEmail_valid_returnHappy() {
        try {
            assertTrue(UserRegistrationClass.checkEmail("yogesh.100@gmail.com.au"));
        } catch (UserRegistrationException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testEmail_invalid_throwsException() {
        try {
            UserRegistrationClass.checkEmail("yog@com");
            fail("Expected UserRegistrationException was not thrown");
        } catch (UserRegistrationException e) {
            assertEquals("Invalid Email:Enter email like this format abc.xyz@bl.co.in", e.getMessage());
        }
    }

    @Test
    public void testMobileNo_valid_returnHappy() {
        try {
            assertTrue(UserRegistrationClass.checkMobileNo("91 9576543210"));
        } catch (UserRegistrationException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testMobileNo_invalid_throwsException() {
        try {
            UserRegistrationClass.checkMobileNo("9576543210");
            fail("Expected UserRegistrationException was not thrown");
        } catch (UserRegistrationException e) {
            assertEquals("Invalid Mobile No:Enter 10 digit mobile No with country code like 91 9234567890", e.getMessage());
        }
    }

    @Test
    public void testPassword_valid_returnHappy() {
        try {
            assertTrue(UserRegistrationClass.checkPassword("Katole@123"));
        } catch (UserRegistrationException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testPassword_invalid_throwsException() {
        try {
            UserRegistrationClass.checkPassword("Katole");
            fail("Expected UserRegistrationException was not thrown");
        } catch (UserRegistrationException e) {
            assertEquals("Invalid Password:Enter password like minimum 8 chars and at least 1 uppercase char and at least 1 digit and exact 1 special char.", e.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = { "abc@yahoo.com", "abc-100@yahoo.com", "abc.100@yahoo.com", "abc111@abc.com",
            "abc-100@abc.net", "abc.100@abc.com.au", "abc@1.com", "abc@gmail.com.com", "abc+100@gmail.com" })
    public void testSampleEmail_valid_returnHappy(String email) {
        try {
            assertTrue(UserRegistrationClass.checkSampleEmail(email));
        } catch (UserRegistrationException e) {
            fail("Unexpected exception for email: " + email + " - " + e.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = { "abc", "abc@.com.my", "abc123@gmail.a", "abc123@.com", "abc123@.com.com", ".abc@abc.com",
            "abc()*@gmail.com", "abc@%*.com", "abc..2002@gmail.com", "abc.@gmail.com", "abc@abc@gmail.com",
            "abc@gmail.com.1a", "abc@gmail.com.aa.au" })
    public void testSampleEmail_invalid_throwsException(String email) {
        try {
            UserRegistrationClass.checkSampleEmail(email);
            fail("Expected UserRegistrationException was not thrown for email: " + email);
        } catch (UserRegistrationException e) {
            assertEquals("Invalid Email:follow standard email format.", e.getMessage());
        }
    }
}
