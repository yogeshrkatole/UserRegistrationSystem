package main.java;
@FunctionalInterface
public interface UserValidation {
 
	boolean validate(String input) throws UserRegistrationException;
	
}
