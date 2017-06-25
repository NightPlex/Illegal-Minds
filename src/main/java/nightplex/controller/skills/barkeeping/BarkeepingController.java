package nightplex.controller.skills.barkeeping;

import nightplex.model.Account;
import nightplex.model.template.skills.barkeeping.DrinkData;
import nightplex.model.template.skills.barkeeping.DrinkSelected;
import nightplex.services.GeneralService;
import nightplex.services.account.AccountInformationService;
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
@RequestMapping("/tavern")
public class BarkeepingController {

    @Autowired
    private AccountInformationService accountInformationService;

    @Autowired
    private BarKeepingService barKeepingService;

    @Autowired
    private GeneralService generalService;

    @ModelAttribute("userAccount")
    public Account getAccount() {
        return accountInformationService.getCurrentAccount();
    }

    @RequestMapping(value = "/")
    public String barkeepingTavern(Model model) {

        return "game/skills/barkeeping/barkeeping";

    }

    @RequestMapping(value = "/toggle", method = RequestMethod.POST)
    public String toggleBar(Model model) {
        barKeepingService.toggleBar();
        return "game/skills/barkeeping/barkeeping";
    }

    @RequestMapping(value = "/kitchen")
    public String barkeepingMainPage(Model model) {
        List<DrinkData> testDrinks = new LinkedList<>();
        for (int id : generalService.getDrinks().keySet()) {
            testDrinks.add(generalService.getDrink(id));
        }

        model.addAttribute("drinks", testDrinks);
        model.addAttribute("selectedDrink", new DrinkSelected());
        return "game/skills/barkeeping/kitchen";

    }

    @RequestMapping(value = "/makedrink", method = RequestMethod.POST)
    public String makeDrink(@ModelAttribute("selectedDrink") DrinkSelected drinkSelected, Model model) {
        barKeepingService.buyRawMaterial(100, "water");
        barKeepingService.makeDrink(drinkSelected.getDrinkId());
        List<DrinkData> testDrinks = new LinkedList<>();
        for (int id : generalService.getDrinks().keySet()) {
            testDrinks.add(generalService.getDrink(id));
        }

        model.addAttribute("drinks", testDrinks);
        model.addAttribute("selectedDrink", new DrinkSelected(drinkSelected.getDrinkId()));
        return "game/skills/barkeeping/kitchen";

    }

}
