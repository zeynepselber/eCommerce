package taskForDay5.core.concretes;

import taskForDay5.GoogleAuth.GoogleAuthManager;
import taskForDay5.business.abstracts.AuthService;

public class GoogleAuthManagerAdapter implements AuthService{

	GoogleAuthManager googleManager ;
	
	public GoogleAuthManagerAdapter( GoogleAuthManager googleManager ) {
		this.googleManager = googleManager ;
	}
	
	@Override
	public void signUp(String firstName, String lastName, String email, String password) {
		googleManager.signUp(email, password);
		
	}

	@Override
	public void login(String email, String password) {
		googleManager.login(email, password);
		
	}

}
