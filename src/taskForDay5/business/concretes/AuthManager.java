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
				
				System.out.println("Kayýt iþleminiz baþarýlý. E-postanýza gelen doðrulama linkine týklayarak üyelik iþlemlerinizi tamamlayýnýz.");
				
			}
			else
				System.out.println("Girilen e-posta adresine ait kayýt bulunmaktadýr.");
			
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
				System.out.println("Hatalý Giriþ : E-posta ya da þifre hatalý.");
			else if( !userToLogin.getIsValid() )
				System.out.println("Hatalý Giriþ : Lütfen e-postanýzý kontrol ediniz. Üyeliðinizi doðrulayýnýz.");
			else
				System.out.println("Baþarýlý Giriþ : " + userToLogin.getFirstName() +" "+userToLogin.getLastName());
			
		}
		else
			System.out.println("Hatalý Giriþ : " + validateMessage);

	}

}
