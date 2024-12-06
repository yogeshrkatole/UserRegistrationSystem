package test.java;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

	@ParameterizedTest
	@ValueSource(strings = { "abc@yahoo.com", " abc-100@yahoo.com", "abc.100@yahoo.com", "abc111@abc.com",
			"abc-100@abc.net", "abc.100@abc.com.au", "abc@1.com", "abc@gmail.com.com", "abc+100@gmail.com" })
	public void testSampleEmail_valid_returnHappy() {
		assertTrue(UserRegistrationClass.checkSampleEmail("abc@yahoo.com"));
	}

	@ParameterizedTest
	@ValueSource(strings = { "abc", "abc@.com.my", "abc123@gmail.a", "abc123@.com", "abc123@.com.com", ".abc@abc.com",
			"abc()*@gmail.com", "abc@%*.com", "abc..2002@gmail.com", "abc.@gmail.com", "abc@abc@gmail.com",
			"abc@gmail.com.1a", "abc@gmail.com.aa.au" })
	public void testSampleEmail_invalid_returnSad() {
		assertFalse(UserRegistrationClass.checkSampleEmail("abc@.com.my"));
	}
}
