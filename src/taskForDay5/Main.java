package taskForDay5;

import java.util.List;

import taskForDay5.GoogleAuth.GoogleAuthManager;
import taskForDay5.business.abstracts.AuthService;
import taskForDay5.business.abstracts.UserService;
import taskForDay5.business.concretes.UserManager;
import taskForDay5.business.concretes.ValidationManager;
import taskForDay5.core.concretes.EmailManager;
import taskForDay5.core.concretes.GoogleAuthManagerAdapter;
import taskForDay5.dataAccess.concretes.HibernateUserDao;
import taskForDay5.entities.concretes.User;
import taskForDay5.business.concretes.AuthManager;

public class Main {

	public static void main(String[] args) {
		
		UserService userService    = new UserManager( new HibernateUserDao() ) ;
		AuthService authentication = new AuthManager( userService , new ValidationManager() , new EmailManager());

		authentication.signUp("", "SELBER", "zeynep.selber@gmail.com", "1234");          // isim bo� olamaz hatas�
		authentication.signUp("Zeynep", "", "zeynep.selber@gmail.com", "1234");          // soyad� bo� olamaz hatas�
		authentication.signUp("Zeynep", "SELBER", "zeynep.selber.com", "12349666");      // gecersiz email hatas�
		authentication.signUp("Zeynep", "SELBER", "zeynep.selber@gmail.com", "1234");    // parola uzunluk hatas�
		authentication.signUp("Zeynep", "SELBER", "zeynep.selber@gmail.com", "123456");  // BASARILI uyelik
		
		User userInfo = userService.getWithEmail("zeynep.selber@gmail.com") ; // uye bilgi cekildi
		userService.verify(userInfo.getId()); // uyelik dogruland�
		
		authentication.login("", "");                                  // hatal� giris 
		authentication.login("zeynep.selber@gmail.com", "");           // hatal� giris 
		authentication.login("zeynep.selber@gmail.com", "1235");       // hatal� giris
		authentication.login("zeynep.selber@gmail.com", "123587999");  // hatal� giris
		authentication.login("zeynep.selber@gmail.com", "123456");     // BASARILI giri�
		
		AuthService authenticationWithGoogle = new GoogleAuthManagerAdapter( new GoogleAuthManager());
		authenticationWithGoogle.signUp("Zeynep", "SELBER", "zeynep.selber@gmail.com", "1111111"); // BASARILI uyelik
		authenticationWithGoogle.login("zeynep.selber@gmail.com", "1111111"); // BASARILI giris
		
		/*List<User> users = userService.getAll();
		
		for(User user : users) {
			System.out.println(user.getEmail());
		}*/
	}

}
