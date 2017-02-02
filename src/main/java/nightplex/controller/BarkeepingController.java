package nightplex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nightplex.services.barkeeping.BarKeepingService;
import nightplex.services.repository.AccountRepository;
import nightplex.services.repository.UserRepository;

@Controller
public class BarkeepingController {
	
	@Autowired
	private AccountRepository repo;
	
	@Autowired
	private BarKeepingService bar;
	
	
	@RequestMapping(value = "/game/tavern")
	public String barkeepingTavern(Model model) {
		
		model.addAttribute("userAccount", repo.getById(1L));
		
		System.out.println(bar.buyBar());
		
		
		
		
		
		return "game/barkeeping";
		
	}
	
	@RequestMapping(value = "/tavern/{place}", method = RequestMethod.GET)
	public String barkeepingMainPage() {
		
		return "index";
		
	}
	

}
