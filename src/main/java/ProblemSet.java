/**

	* File: ProblemSet

	* Author: Nithin.A

	* Date Created: March 27th, 2026

	* Date Last Modified: April 7th, 2026

	*/

import java.util.Scanner;

public class ProblemSet {


	public static void main(String args[]) {
		Scanner i = new Scanner(System.in);
		System.out.print("Input one or two email(s): ");
		String email = i.nextLine();
		System.out.println(emailPrinter(email));

	}

	
	// parses and decides which format to out string in
	public static String emailPrinter(String email){
		// checks for two emails, parses them and sends them to email validator then format and prints the output accordingly
		if (email.contains(", ")) {
			String email1 = email.substring(0, email.indexOf(", "));
			String email2 = email.substring(email.indexOf(", ") + 2);

		// checks if email(s) is invalid or not and formats output accordingly
			if (emailValidator(email1).contains("Invalid")){
				email1 = email1 + ": " + emailValidator(email1);
			}
			else {
				email1 = email1 + ": " + emailValidator(email1) + " | Local: " + localPart(email1) + " | Domain: " + domainPart(email1);
			}
			if (emailValidator(email2).contains("Invalid")){
				email2 = email2 + ": " + emailValidator(email2);
			}
			else {
				email2 = email2 + ": " + emailValidator(email2) + " | Local: " + localPart(email2) + " | Domain: " + domainPart(email2);
			}
			return email1 + "\n" + email2;
		}
		if (emailValidator(email).contains("Invalid")){
			return email + ": " + emailValidator(email);
		}
		return email + ": " + emailValidator(email) + " | Local: " + localPart(email) + " | Domain: " + domainPart(email);
	}

	// checks if the email input passes the requirements
	public static String emailValidator(String email){
		String validStatement;

		// checking for multiple @s
		if (!email.contains("@")){
			return "Invalid: Missing @";
		}

		// checks for @
		else if (email.indexOf("@") != email.lastIndexOf("@")){
			return "Invalid: Multiple @";
		}
		// Removing ".", "+", and "_" for @gmail.com domain for remaining checks
		if (email.endsWith("@gmail.com")){
			email = localPart(email).replaceAll("\\.", "")
									.replaceAll("\\+", "")
									.replaceAll("\\_", "") + "@" + domainPart(email);
			validStatement = "Valid (Gmail normalized)";
		}

		// Checks if domainPart starts with.
		if (domainPart(email).startsWith(".")){
			return "Invalid: Domain Starts with dot";
		}
		
		// checks if email starts or ends with "."
		else if (email.startsWith(".") || email.endsWith(".") || email.startsWith("+") || email.endsWith("+") || email.startsWith("_") || email.endsWith("_")){
			return "Invalid: Starts or ends with dot, plus sign, or underscore";
		}
		// checks if email contains spaces
		else if (email.contains(" ")){
			return "Invalid: Contains spaces"; 
		}
		// checks if email local part is too long
		else if (64 < localPart(email).length()){
			return "Invalid: Local part too long";
		}
		// checks if email local part too short
		else if (1 > localPart(email).length()){
			return "Invalid: Local part too short";
		}
		// checks if email checks for "." in domain
		else if (!domainPart(email).contains(".")){
			return "Invalid: No dot in domain";
		}
		// checks if domainPart contains "+" or "_"
		else if (domainPart(email).contains("+") || domainPart(email).contains("_")){
			return "Invalid: Invalid characters in domain";
		}
		// checks if email has too long or too short domain extension length
		else if (2 > email.substring(email.lastIndexOf(".") + 1).length() || 6 < email.substring(email.lastIndexOf(".") + 1).length()){
			return "Invalid: Invalid domain extension length";
		}
		
		else {
			validStatement = "Valid";
		}
		// returns valid if all checks pass
		return validStatement;
			
	}

	// For parsing domain part of email input
	public static String domainPart(String email){
		return email.substring(email.indexOf("@") + 1);
	}
	// For parsing local part of email input
	public static String localPart(String email){
		return email.substring(0, email.indexOf("@"));
	}

}

