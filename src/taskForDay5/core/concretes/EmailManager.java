package taskForDay5.core.concretes;

import taskForDay5.core.abstracts.EmailService;

public class EmailManager implements EmailService{

	@Override
	public void sendMail(String name) {
		System.out.println("Say�n " + name + " �yelik i�lemlerinizin tamamlanmas� i�in a�a��daki do�rulama linkine t�klay�n�z. \n ...DOGRULAMA LINKI..." );
		
	}

}
