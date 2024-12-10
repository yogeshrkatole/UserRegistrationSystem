package main.java;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserRegistrationClass {
	public static void main(String args[]) {
		System.out.println("Welcome to User Registration System");

		try(Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter first name like contains at least 3 char and starts with capital :");
			String firstName = scanner.nextLine();

			 check(firstName, checkFirstOrLastName, "FirstName");


			System.out.print("Enter last name like contains at least 3 char and starts with capital :");
			String lastName = scanner.nextLine();

			 check(lastName, checkFirstOrLastName, "LastName");


			System.out.print("Enter email like this format abc.xyz@bl.co.in :");
			String email = scanner.nextLine();

			 check(email, checkEmail, "Email");

			System.out.print("Enter 10 digit mobile No with country code like 91 9234567890 :");
			String mobileNo = scanner.nextLine();

			check(mobileNo, checkMobileNo, "MobileNo");

			System.out.print(
					"Enter password like minimum 8 chars and at least 1 uppercase char and at least 1 digit and exact 1 special char :");
			String password = scanner.nextLine();

			check(password, checkPassword, "Password");


		String[] validEmails = { "abc@yahoo.com", "abc-100@yahoo.com", "abc.100@yahoo.com", "abc111@abc.com",
				"abc-100@abc.net", "abc.100@abc.com.au", "abc@1.com", "abc@gmail.com.com", "abc+100@gmail.com" };
		for (String e : validEmails) {
			System.out.println(e + " is " + (checkSampleEmail(e) ? "Correct Format" : "Incorrect format"));
		}

		String[] invalidEmails = { "abc", "abc@.com.my", "abc123@gmail.a", "abc123@.com", "abc123@.com.com",
				".abc@abc.com", "abc()*@gmail.com", "abc@%*.com", "abc..2002@gmail.com", "abc.@gmail.com",
				"abc@abc@gmail.com", "abc@gmail.com.1a", "abc@gmail.com.aa.au" };
		for (String e : invalidEmails) {
			System.out.println(e + " is " + (checkSampleEmail(e) ? "Correct Format" : "Incorrect format"));
		}
		} catch (UserRegistrationException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public static final UserValidation checkFirstOrLastName = input -> {
        String regex = "^[A-Z][a-z]{2,}$";
        if (!Pattern.matches(regex, input)) {
        	throw new UserRegistrationException("Invalid Name: Start with a capital letter and contains at least 3 characters.");
        }
        return true;
    };

	public static final UserValidation checkEmail= input -> {
		String regex = "^[a-zA-Z0-9]+([._][a-zA-Z0-9]+)*@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})?$";
	     if(!Pattern.matches(regex, input)) {
	    	 throw new UserRegistrationException("Invalid Email:Enter email like this format abc.xyz@bl.co.in");
		}
	     return true;
	};

	public static final UserValidation checkMobileNo= input -> {
		String regex = "^[0-9]{1,3} [0-9]{10}$";
		if(!Pattern.matches(regex, input)) {
			throw new UserRegistrationException("Invalid Mobile No:Enter 10 digit mobile No with country code like 91 9234567890");
		}
		return true;
	};

	public static final UserValidation checkPassword= input -> {
		String charLength = "^.{8,}$";
		String uppercaseChar = ".*[A-Z].*";
		String numericChar = ".*[0-9].*";
		String specialChar = "^[a-zA-Z0-9]*[!@#$%^&*()_+\\-={}\\[\\]:;\"'<>,.?/\\|\\`~][a-zA-Z0-9]*$";
		if (!Pattern.matches(charLength, input) || 
		        !Pattern.matches(uppercaseChar, input) || 
		        !Pattern.matches(numericChar, input) || 
		        !Pattern.matches(specialChar, input)) {
		        throw new UserRegistrationException("Invalid Password:Enter password like minimum 8 chars and at least 1 uppercase char and at least 1 digit and exact 1 special char.");
		    }
		return true;
	};

	public static final UserValidation checkSampleEmail= input -> {
		String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z]{2,}){1,2}$";

		if(!Pattern.matches(emailPattern, input)) {
			throw new UserRegistrationException("Invalid Email:follow standard email format.");
		}
		return true;
	};
	private static void check(String input, UserValidation checker, String fieldName) { 
        try {
            if (checker.validate(input)) { 
                System.out.println(fieldName + " is Correct");
            }
        } catch (UserRegistrationException e) {
            System.out.println("Incorrect " + fieldName + ": " + e.getMessage());
        }
    }
	private static boolean checkSampleEmail(String email) throws UserRegistrationException { 
        return checkSampleEmail.validate(email);
    }
}
