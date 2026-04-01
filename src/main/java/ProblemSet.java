import java.util.Scanner;

public class ProblemSet {



	public static void main(String args[]) {
		Scanner i = new Scanner(System.out);
		System.out.println("Input an email: ");
		String email = i.nextLine();
		

	}

	// !>&&>||
	public static String emailValidator(String email){
		if (!email.contains("@")){
			return "";
		}
		
		if (email.indexOf("@") != email.lastIndexOf("@")){
			return "";
		}

		if (email.startsWith(".") || email.endsWith(".")){
			return "";
		}

		if (!email.contain(" ")){
			return ""; 
		}

		if (1 >= email.length(localPart(email)) >= 64){
			return "";
		}
		if (domainPart(email).contains(".")){
			
		}

		if (2 >= email.length(domainPart(email)) >= 6){
			return "";
		}
			
	}

	public static String localPart(String email){
		return email.substring(0, email.indexOf("@"));
	}
	public static String domainPart(String email){
		return email.substring(email.IndexOf("@")+1);
	}
}

