package nightplex.controller;

import org.springframework.beans.factory.annotation.Autowired;

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
	
	@RequestMapping("/game/**")
	public String gamePage(Model model) {
		
		
		
		model.addAttribute("test", repo.getById(1L));
		
		return "game/index";
		
	}

}
