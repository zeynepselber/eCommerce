package taskForDay5.dataAccess.concretes;

import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;

import taskForDay5.dataAccess.abstracts.UserDao;
import taskForDay5.entities.concretes.User;

public class HibernateUserDao implements UserDao{

	List<User> users = new ArrayList<User>();
	
	@Override
	public void add(User user) {
		
		int userCount = users.size();
		user.setId(userCount++);
		
		users.add(user) ;
		
	}

	@Override
	public void update(User user) {
		User userUpdating = get( user.getId() ); // guncellenecek user bilgileri alýnýyor
		userUpdating.setFirstName(user.getFirstName());
		userUpdating.setLastName(user.getLastName());
		
	}

	@Override
	public User get(int id) {
		
		for(User user :  this.users) {
			if( user.getId() == id )
				return user ;
		}
		return null ;
	}

	@Override
	public User getWithEmail(String email) {
		
		for(User user : this.users) {
			
			if( user.getEmail() == email)
				return user ;
		}
		
		return null;
	}

	@Override
	public User getWithEmailPassword(String email, String password) {
		
		for(User user : this.users) {
			
			if( user.getEmail() == email && user.getPassword() == password)
				return user ;
		}
		
		return null;
		
	}

	@Override
	public List<User> getAll() {
		return users;
	}

}
