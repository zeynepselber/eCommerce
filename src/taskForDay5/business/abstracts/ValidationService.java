package taskForDay5.business.abstracts;

import taskForDay5.entities.concretes.User;

public interface ValidationService {

	String validate(String email, String password);
	
	String validate(String firstName, String lastName, String email, String password);
}
