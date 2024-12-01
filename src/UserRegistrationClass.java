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
         
         System.out.print("Enter password like minimum 8 chars :"); 
         String password = scanner.nextLine();

         if (checkPassword(password)) { 
             System.out.println("Password is Correct"); 
         } else {
             System.out.println("Incorrect Password"); 
         }
         scanner.close();
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
	        String regex = "^.{8}$";
	        return Pattern.matches(regex, password);
	    }
}
