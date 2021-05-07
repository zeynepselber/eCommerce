package taskForDay5.business.abstracts;

public interface AuthService {
	void signUp(String firstName, String lastName, String email, String password);
	void login(String email , String password);
}
