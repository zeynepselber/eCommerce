package taskForDay5.business.concretes;

import java.util.regex.Pattern;

import taskForDay5.business.abstracts.ValidationService;
import taskForDay5.entities.concretes.User;

public class ValidationManager implements ValidationService{

	// Kaynak : https://stackoverflow.com/a/8204716/13150378
		public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
			    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		
		@Override
		public String validate(String email, String password) {
			String message ;
			
			if(email.isEmpty()) {
				message = "Lütfen email adresinizi giriniz.";
			}
			else if(password.isEmpty()) {
				message = "Lütfen þifrenizi giriniz." ;
			}
			else if( password.length() < 6 ) {
				message = "Parolanýz en az 6 karakterden oluþmalýdýr." ;
			}
			else if( !isEmailValid(email)) {
				message = "Lütfen geçerli bir email adresi giriniz." ;
			}
			else
				message = "" ;
			
			return message ;
		}
		
		@Override
		public String validate(String firstName, String lastName, String email, String password) {
		
		String message ;
		
		if(firstName.isEmpty()) {
			message = "Lütfen adýnýzý giriniz." ;
		}
		else if(lastName.isEmpty()) {
			message = "Lütfen soyadýnýzý giriniz." ;
		}
		else if(email.isEmpty()) {
			message = "Lütfen email adresinizi giriniz.";
		}
		else if(password.isEmpty()) {
			message = "Lütfen þifrenizi giriniz." ;
		}
		else if( password.length() < 6 ) {
			message = "Parolanýz en az 6 karakterden oluþmalýdýr." ;
		}
		else if( firstName.length() < 2 ) {
			message = "Adýnýz en az 2 karakterden oluþmalýdýr.";
		}
		else if( lastName.length() < 2 ) {
			message = "Soyadýnýz en az 2 karakterden oluþmalýdýr." ;
		}
		else if( !isEmailValid(email)) {
			message = "Lütfen geçerli bir email adresi giriniz." ;
		}
		else
			message = "" ;
		
		return message ;
	}
	
	private boolean isEmailValid(String email) {
		return VALID_EMAIL_ADDRESS_REGEX.matcher(email).find();
	}

}
