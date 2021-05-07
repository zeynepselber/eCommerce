package taskForDay5.business.concretes;

import taskForDay5.business.abstracts.AuthService;

import taskForDay5.business.abstracts.UserService;
import taskForDay5.business.abstracts.ValidationService;
import taskForDay5.core.abstracts.EmailService;
import taskForDay5.entities.concretes.User;

public class AuthManager implements AuthService{

	UserService userService ;
	ValidationService validationService ;
	EmailService emailService ;
	
    public AuthManager(UserService userService , ValidationService validationService , EmailService emailService) {
	
    	this.userService       = userService ;
    	this.validationService = validationService ;
    	this.emailService      = emailService ;
	}

	@Override
	public void signUp(String firstName, String lastName, String email, String password) {
		
		String validateMessage = validationService.validate(firstName, lastName, email, password) ;
		
		if( validateMessage.isEmpty()) {
			
			if( userService.getWithEmail(email) == null) {
				
				User user = new User(firstName, lastName, email, password);
				userService.add(user);
				
				emailService.sendMail( firstName+" "+lastName );
				
				System.out.println("Kay�t i�leminiz ba�ar�l�. E-postan�za gelen do�rulama linkine t�klayarak �yelik i�lemlerinizi tamamlay�n�z.");
				
			}
			else
				System.out.println("Girilen e-posta adresine ait kay�t bulunmaktad�r.");
			
		}
		else
			System.out.println(validateMessage);
		
	}

	@Override
	public void login(String email, String password) {
		
		String validateMessage = validationService.validate( email, password) ;
		
		if( validateMessage.isEmpty()) {
			
			User userToLogin = userService.getWithEmailPassword(email,password) ;
			
			if( userToLogin == null ) 
				System.out.println("Hatal� Giri� : E-posta ya da �ifre hatal�.");
			else if( !userToLogin.getIsValid() )
				System.out.println("Hatal� Giri� : L�tfen e-postan�z� kontrol ediniz. �yeli�inizi do�rulay�n�z.");
			else
				System.out.println("Ba�ar�l� Giri� : " + userToLogin.getFirstName() +" "+userToLogin.getLastName());
			
		}
		else
			System.out.println("Hatal� Giri� : " + validateMessage);

	}

}
