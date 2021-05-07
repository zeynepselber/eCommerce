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
				message = "L�tfen email adresinizi giriniz.";
			}
			else if(password.isEmpty()) {
				message = "L�tfen �ifrenizi giriniz." ;
			}
			else if( password.length() < 6 ) {
				message = "Parolan�z en az 6 karakterden olu�mal�d�r." ;
			}
			else if( !isEmailValid(email)) {
				message = "L�tfen ge�erli bir email adresi giriniz." ;
			}
			else
				message = "" ;
			
			return message ;
		}
		
		@Override
		public String validate(String firstName, String lastName, String email, String password) {
		
		String message ;
		
		if(firstName.isEmpty()) {
			message = "L�tfen ad�n�z� giriniz." ;
		}
		else if(lastName.isEmpty()) {
			message = "L�tfen soyad�n�z� giriniz." ;
		}
		else if(email.isEmpty()) {
			message = "L�tfen email adresinizi giriniz.";
		}
		else if(password.isEmpty()) {
			message = "L�tfen �ifrenizi giriniz." ;
		}
		else if( password.length() < 6 ) {
			message = "Parolan�z en az 6 karakterden olu�mal�d�r." ;
		}
		else if( firstName.length() < 2 ) {
			message = "Ad�n�z en az 2 karakterden olu�mal�d�r.";
		}
		else if( lastName.length() < 2 ) {
			message = "Soyad�n�z en az 2 karakterden olu�mal�d�r." ;
		}
		else if( !isEmailValid(email)) {
			message = "L�tfen ge�erli bir email adresi giriniz." ;
		}
		else
			message = "" ;
		
		return message ;
	}
	
	private boolean isEmailValid(String email) {
		return VALID_EMAIL_ADDRESS_REGEX.matcher(email).find();
	}

}
