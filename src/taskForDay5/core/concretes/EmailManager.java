package taskForDay5.core.concretes;

import taskForDay5.core.abstracts.EmailService;

public class EmailManager implements EmailService{

	@Override
	public void sendMail(String name) {
		System.out.println("Sayýn " + name + " üyelik iþlemlerinizin tamamlanmasý için aþaðýdaki doðrulama linkine týklayýnýz. \n ...DOGRULAMA LINKI..." );
		
	}

}
