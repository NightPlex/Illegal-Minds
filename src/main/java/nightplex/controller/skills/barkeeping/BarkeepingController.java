package nightplex.controller.skills.barkeeping;

import nightplex.ServerCONF;
import nightplex.model.Account;
import nightplex.model.template.skills.barkeeping.DrinkSelected;
import nightplex.model.template.skills.barkeeping.Material;
import nightplex.services.account.AccountInformationService;
import nightplex.services.account.AccountScheduledTasks;
import nightplex.services.skills.barkeeping.BarKeepingService;
import nightplex.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/tavern")
public class BarkeepingController {

    @Autowired
    private AccountInformationService accountInformationService;

    @Autowired
    private BarKeepingService barKeepingService;

    @Autowired
    private AccountScheduledTasks accountScheduledTasks;

    @ModelAttribute("userAccount")
    public Account getAccount() {
        return accountInformationService.getCurrentAccount();
    }

    @ModelAttribute("nextCustomers")
    public String getNextCustomers() {

        int counter = accountScheduledTasks.getNextCustomers();

        int nextCustomers = ServerCONF.DRINK_UPDATE_TIME-counter;

        return StringUtils.transferIntToStringTime(nextCustomers);
    }

    @RequestMapping(value = "/")
    public String barkeepingTavern(Model model) {
        return "game/skills/barkeeping/barkeeping";

    }

    @RequestMapping(value = "/toggle", method = RequestMethod.POST)
    public String toggleBar() {
        barKeepingService.toggleBar();
        return "game/skills/barkeeping/barkeeping";
    }

    @RequestMapping(value = "/kitchen")
    public String barkeepingMainPage(Model model) {
        model.addAttribute("drinks", barKeepingService.getAllDrinks());
        model.addAttribute("selectedDrink", new DrinkSelected());
        return "game/skills/barkeeping/kitchen";
    }
    @RequestMapping(value = "/office")
    public String barkeepingOffice(Model model) {
        model.addAttribute("selectedMaterial" , new Material());
        model.addAttribute("rawMaterials", barKeepingService.getAllMaterial());
        model.addAttribute("playersMaterial", barKeepingService.getPlayersMaterial());
        model.addAttribute("playersDrinks", barKeepingService.getAllPlayerDrinks());
        return "game/skills/barkeeping/office";
    }

    @RequestMapping(value = "/office/buy", method = RequestMethod.POST)
    public String buyRawMaterial(@ModelAttribute("selectedMaterial") Material material, Model model) {
        barKeepingService.buyRawMaterial(material.getAmount(), material.getName());
        return "redirect:/tavern/office";
    }

    @RequestMapping(value = "/makedrink", method = RequestMethod.POST)
    public String makeDrink(@ModelAttribute("selectedDrink") DrinkSelected drinkSelected, Model model) {
        barKeepingService.makeDrink(drinkSelected.getDrinkId());
        model.addAttribute("drinks", barKeepingService.getAllDrinks());
        model.addAttribute("selectedDrink", new DrinkSelected(drinkSelected.getDrinkId()));
        return "game/skills/barkeeping/kitchen";

    }

}
