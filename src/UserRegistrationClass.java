import java.util.Scanner;
import java.util.regex.Pattern;

public class UserRegistrationClass {
	public static void main(String args[]) {
		System.out.println("Welcome to User Registration System");

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter first name like contains at least 3 char and starts with capital :");
		String firstName = scanner.nextLine();

		if (checkFirstName(firstName)) {
			System.out.println("First Name is Correct");
		} else {
			System.out.println("Incorrect First Name ");
		}

		System.out.print("Enter last name like contains at least 3 char and starts with capital :");
		String lastName = scanner.nextLine();

		if (checkFirstName(lastName)) {
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
	}

	public static boolean checkFirstName(String firstOrLastName) {
		String regex = "^[A-Z][a-z]{2,}$";
		return Pattern.matches(regex, firstOrLastName);
	}

	public static boolean checkEmail(String email) {
		String regex = "^[a-zA-Z0-9]+([._][a-zA-Z0-9]+)*@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}(\\.[a-zA-Z]{2,})?$";
		return Pattern.matches(regex, email);
	}

	public static boolean checkMobileNo(String mobileNo) {
		String regex = "^[0-9]{1,3} [0-9]{10}$";
		return Pattern.matches(regex, mobileNo);
	}

	public static boolean checkPassword(String password) {
		String charLength = "^.{8,}$";
		String uppercaseChar = ".*[A-Z].*";
		String numericChar = ".*[0-9].*";
		String specialChar = "^[a-zA-Z0-9]*[!@#$%^&*()_+\\-={}\\[\\]:;\"'<>,.?/\\|\\`~][a-zA-Z0-9]*$";
		return Pattern.matches(charLength, password) && Pattern.matches(uppercaseChar, password)
				&& Pattern.matches(numericChar, password) && Pattern.matches(specialChar, password);
	}

	public static boolean checkSampleEmail(String email) {
		String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z]{2,}){1,2}$";

		return Pattern.matches(emailPattern, email);
	}
}
