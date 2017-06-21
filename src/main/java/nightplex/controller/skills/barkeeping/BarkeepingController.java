package nightplex.controller.skills.barkeeping;

import nightplex.model.template.skills.barkeeping.DrinkData;
import nightplex.model.template.skills.barkeeping.DrinkSelected;
import nightplex.services.GeneralService;
import nightplex.services.repository.AccountRepository;
import nightplex.services.skills.barkeeping.BarKeepingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.LinkedList;
import java.util.List;

@Controller
public class BarkeepingController {

    @Autowired
    private AccountRepository repo;

    @Autowired
    private BarKeepingService barKeepingService;

    @Autowired
    private GeneralService generalService;

    @RequestMapping(value = "/game/tavern")
    public String barkeepingTavern(Model model) {

        model.addAttribute("userAccount", repo.getById(1L));

        System.out.println(barKeepingService.buyBar());

        return "game/barkeeping";

    }

    @RequestMapping(value = "/game/toggle", method = RequestMethod.POST)
    public String toggleBar(Model model) {
        barKeepingService.toggleBar();
        System.out.println("Toggled: " + repo.getById(1L).getBarkeeping().isBarIsClosed());
        model.addAttribute("userAccount", repo.getById(1L));
        return "game/barkeeping";
    }

    @RequestMapping(value = "/tavern/kitchen")
    public String barkeepingMainPage(Model model) {
        model.addAttribute("userAccount", repo.getById(1L));
        List<DrinkData> testDrinks = new LinkedList<>();
        for(int id : generalService.getDrinks().keySet()) {
            testDrinks.add(generalService.getDrink(id));
        }

        model.addAttribute("drinks", testDrinks);
        model.addAttribute("selectedDrink" , new DrinkSelected());
        return "game/barkeeping";

    }

    @RequestMapping(value = "/tavern/makedrink", method = RequestMethod.POST)
    public String makeDrink(@ModelAttribute("selectedDrink") DrinkSelected drinkSelected, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            System.out.println("error");
            return "index";
        }
        System.out.println(drinkSelected.getDrinkId());
        model.addAttribute("userAccount", repo.getById(1L));
        barKeepingService.makeDrink(drinkSelected.getDrinkId());
        return "game/barkeeping";

    }

}
