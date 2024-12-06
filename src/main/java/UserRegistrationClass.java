package main.java;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserRegistrationClass {
	public static void main(String args[]) {
		System.out.println("Welcome to User Registration System");

		Scanner scanner = new Scanner(System.in);
		try {
			System.out.print("Enter first name like contains at least 3 char and starts with capital :");
			String firstName = scanner.nextLine();

			if (checkFirstOrLastName(firstName)) {
				System.out.println("First Name is Correct");
			} else {
				System.out.println("Incorrect First Name ");
			}

			System.out.print("Enter last name like contains at least 3 char and starts with capital :");
			String lastName = scanner.nextLine();

			if (checkFirstOrLastName(lastName)) {
				System.out.println("Last Name is Correct");
			} else {
				System.out.println("Incorrect Lastirst Name");
			}

			System.out.print("Enter email like this format abc.xyz@bl.co.in :");
			String email = scanner.nextLine();

			if (checkEmail(email)) {
				System.out.println("Email is Correct");
			} else {
				System.out.println("Incorrect email");
			}

			System.out.print("Enter 10 digit mobile No with country code like 91 9234567890 :");
			String mobileNo = scanner.nextLine();

			if (checkMobileNo(mobileNo)) {
				System.out.println("MobileNo is Correct");
			} else {
				System.out.println("Incorrect MobileNo");
			}

			System.out.print(
					"Enter password like minimum 8 chars and at least 1 uppercase char and at least 1 digit and exact 1 special char :");
			String password = scanner.nextLine();

			if (checkPassword(password)) {
				System.out.println("Password is Correct");
			} else {
				System.out.println("Incorrect Password");
			}
		
		scanner.close();

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

	public static boolean checkFirstOrLastName(String firstOrLastName) throws UserRegistrationException {
        String regex = "^[A-Z][a-z]{2,}$";
        if (!Pattern.matches(regex, firstOrLastName)) {
        	throw new UserRegistrationException("Invalid Name: Start with a capital letter and contains at least 3 characters.");
        }
        return true;
    }

	public static boolean checkEmail(String email) throws UserRegistrationException {
		String regex = "^[a-zA-Z0-9]+([._][a-zA-Z0-9]+)*@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})?$";
	     if(!Pattern.matches(regex, email)) {
	    	 throw new UserRegistrationException("Invalid Email:Enter email like this format abc.xyz@bl.co.in");
		}
	     return true;
	}

	public static boolean checkMobileNo(String mobileNo) throws UserRegistrationException {
		String regex = "^[0-9]{1,3} [0-9]{10}$";
		if(!Pattern.matches(regex, mobileNo)) {
			throw new UserRegistrationException("Invalid Mobile No:Enter 10 digit mobile No with country code like 91 9234567890");
		}
		return true;
	}

	public static boolean checkPassword(String password) throws UserRegistrationException {
		String charLength = "^.{8,}$";
		String uppercaseChar = ".*[A-Z].*";
		String numericChar = ".*[0-9].*";
		String specialChar = "^[a-zA-Z0-9]*[!@#$%^&*()_+\\-={}\\[\\]:;\"'<>,.?/\\|\\`~][a-zA-Z0-9]*$";
		if (!Pattern.matches(charLength, password) || 
		        !Pattern.matches(uppercaseChar, password) || 
		        !Pattern.matches(numericChar, password) || 
		        !Pattern.matches(specialChar, password)) {
		        throw new UserRegistrationException("Invalid Password:Enter password like minimum 8 chars and at least 1 uppercase char and at least 1 digit and exact 1 special char.");
		    }
		return true;
	}

	public static boolean checkSampleEmail(String email) throws UserRegistrationException {
		String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z]{2,}){1,2}$";

		if(!Pattern.matches(emailPattern, email)) {
			throw new UserRegistrationException("Invalid Email:follow standard email format.");
		}
		return true;
	}
}
