package nightplex.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import nightplex.model.Account;
import nightplex.model.RegisterForm;
import nightplex.model.User;
import nightplex.model.UserData;
import nightplex.services.NotificationService;
import nightplex.services.repository.AccountRepository;
import nightplex.services.repository.UserRepository;

/*
 * 
 * 
 * 
 * */


@Controller
public class HomeController {
	
	@Autowired
	private NotificationService nService;
	
	@Autowired
	private UserRepository userRepo;
	
	
	@RequestMapping("/")
	public String landingPage(RegisterForm registerForm) {
		
		return "index";
	
	}
	
	
	
	@RequestMapping("/login")
	public String login() {
		
		return "index";
	
	}
	
	// Give registerForm object to the method and fill it with data.
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@Valid RegisterForm registerForm, BindingResult result) {
		
		if(result.hasErrors()) {
			
			nService.addErrorMessage("Error", "Check your registration form");
			
			return "index";
			
		}
		
		// check if the password and email are the same(type twice)
		if (registerForm.getPassword().equals(registerForm.getAgainPassword()) || registerForm.getEmail().equals(registerForm.getAgainEmail())) {
			
			System.out.println(registerForm.toString());
			
			userRepo.save(new User(registerForm.getUsername(), registerForm.getPassword(), "USER"));
			nService.addSuccessMessage("Congratz", "You have successfully registered as member, you may log in!");
			return "redirect:/";
			
		} else {
			
			nService.addErrorMessage("Error", "Email or password does not match");
			return "index";
			
			
		}
		
		
		
		
		
	}

}
