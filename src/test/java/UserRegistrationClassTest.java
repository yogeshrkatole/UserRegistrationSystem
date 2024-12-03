package test.java;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import main.java.UserRegistrationClass;

public class UserRegistrationClassTest {
	@Test
	public void testFirstName_valid_returnHappy() {
		assertTrue(UserRegistrationClass.checkFirstName("Yogesh"));
	}

	@Test
	public void testFirstName_invalid_returnSad() {
		assertFalse(UserRegistrationClass.checkFirstName("yogesh"));
	}

	@Test
	public void testLastName_valid_returnHappy() {
		assertTrue(UserRegistrationClass.checkFirstName("Katole"));
	}

	@Test
	public void testLastName_invalid_returnSad() {
		assertFalse(UserRegistrationClass.checkFirstName("katole"));
	}

	@Test
	public void testEmail_valid_returnHappy() {
		assertTrue(UserRegistrationClass.checkEmail("yogesh.100@gmail.com.au"));
	}

	@Test
	public void testEmail_invalid_returnSad() {
		assertFalse(UserRegistrationClass.checkEmail("yog@com"));
	}

	@Test
	public void testMobileNo_valid_returnHappy() {
		assertTrue(UserRegistrationClass.checkMobileNo("91 9576543210"));
	}

	@Test
	public void testMobileNo_invalid_returnSad() {
		assertFalse(UserRegistrationClass.checkMobileNo("9576543210"));
	}

	@Test
	public void testPassword_valid_returnHappy() {
		assertTrue(UserRegistrationClass.checkPassword("Katole@123"));
	}

	@Test
	public void testPassword_invalid_returnSad() {
		assertFalse(UserRegistrationClass.checkPassword("Katole"));
	}

	@Test
	public void testSampleEmail_valid_returnHappy() {
		assertTrue(UserRegistrationClass.checkSampleEmail("abc@yahoo.com"));
	}

	@Test
	public void testSampleEmail_invalid_returnSad() {
		assertFalse(UserRegistrationClass.checkSampleEmail("abc@.com.my"));
	}
}
