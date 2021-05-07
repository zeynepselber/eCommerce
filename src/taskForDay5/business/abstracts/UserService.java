package taskForDay5.business.abstracts;

import java.util.List;

import taskForDay5.entities.concretes.User;

public interface UserService {

	void add(User user);
	
	void update(User user);
	
	User get(int id);
	
	User getWithEmail(String email);
	
	User getWithEmailPassword(String email , String password);
	
	List<User> getAll();
	
	void verify(int id);
	
}
