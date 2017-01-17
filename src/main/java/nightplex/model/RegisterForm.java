package nightplex.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/*
 * Register form, validation... To check if user submits correct format. 
 * 
 * Also object to hold data until giving to database
 * 
 * 
 * */

public class RegisterForm {

	
	@Size(min = 3, max = 30, message = "Username must be between 3 to 30 chars")
	private String username;
	
	@Email(message = "Must be correct form example@mail.com")
	private String email;
	
	
	@Size(min = 2, max = 30, message = "Password must be between 2 to 30 chars")
	private String password;
	
	@Size(min = 2, max = 30, message = "Password must be between 2 to 30 chars") // check twice
	private String againPassword;
	
	@Email(message = "Must be correct form example@mail.com") // check twice
	private String againEmail;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAgainPassword() {
		return againPassword;
	}

	public void setAgainPassword(String againPassword) {
		this.againPassword = againPassword;
	}

	public String getAgainEmail() {
		return againEmail;
	}

	public void setAgainEmail(String againEmail) {
		this.againEmail = againEmail;
	}

	public RegisterForm(String username, String email, String password, String againPassword, String againEmail) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.againPassword = againPassword;
		this.againEmail = againEmail;
	}

	public RegisterForm() {
		super();
	}

	@Override
	public String toString() {
		return "RegisterForm [username=" + username + ", email=" + email + ", password=" + password + ", againPassword="
				+ againPassword + ", againEmail=" + againEmail + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
