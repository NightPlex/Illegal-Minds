package nightplex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import nightplex.services.repository.AccountRepository;


/*
 * Controller for our game's main part.
 * 
 * Gives the data to website
 * 
 * 
 * */

@Controller
public class GameController {
	
	@Autowired
	private AccountRepository repo;
	
	@RequestMapping("/game")
	public String gamePage(Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		model.addAttribute("userAccount", repo.getByUsername(auth.getName()));
		
		return "game";
		
	}

}
