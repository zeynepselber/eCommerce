package taskForDay5.business.concretes;

import java.util.List;

import taskForDay5.business.abstracts.UserService;
import taskForDay5.dataAccess.abstracts.UserDao;
import taskForDay5.entities.concretes.User;

public class UserManager implements UserService{

	UserDao userDao ;
	
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao ;
	}
	
	@Override
	public void add(User user) {
		userDao.add(user);	
	}

	@Override
	public void update(User user) {
		userDao.update(user);	
	}

	@Override
	public User get(int id) {
		return userDao.get(id);
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public User getWithEmail(String email) {
		return userDao.getWithEmail(email);
	}

	@Override
	public User getWithEmailPassword(String email, String password) {
		return userDao.getWithEmailPassword(email, password);
	}
	
	@Override
	public void verify(int id) {
		User user = userDao.get(id);
		
		user.setIsValid(true);
		
		System.out.println("E-posta doðrulama baþarýlý.Üyelik iþlemleriniz tamamlandý.");
	}

}
