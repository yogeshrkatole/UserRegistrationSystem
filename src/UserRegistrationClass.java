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
         scanner.close();
	 }
	 public static boolean checkFirstName(String firstOrLastName) { 
	     String regex = "^[A-Z][a-z]{2,}$";
	     return Pattern.matches(regex, firstOrLastName);
	 }
}
