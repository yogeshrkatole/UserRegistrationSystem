import java.util.Scanner;
import java.util.regex.Pattern;

public class UserRegistrationClass {
	 public static void main(String args[]) {
		 System.out.println("Welcome to User Registration System");
		 
		 Scanner scanner = new Scanner(System.in);
         System.out.print("Enter first name: "); 
         String firstName = scanner.nextLine();

         if (checkFirstName(firstName)) { 
             System.out.println("First Name is Correct"); 
         } else {
             System.out.println("Incorrect\nFirst Name contains at least 3 char and starts with capital"); 
         }
         
         System.out.print("Enter last name: "); 
         String lastName = scanner.nextLine();

         if (checkFirstName(lastName)) { 
             System.out.println("Last Name is Correct"); 
         } else {
             System.out.println("Incorrect\nLastirst Name contains at least 3 char and starts with capital"); 
         }
         
         System.out.print("Enter email: "); 
         String email = scanner.nextLine();

         if (checkEmail(email)) { 
             System.out.println("Email is Correct"); 
         } else {
             System.out.println("Incorrect\n Enter like this format abc.xyz@bl.co.in"); 
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
}
