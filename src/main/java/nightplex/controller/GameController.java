package nightplex.controller;

import nightplex.model.Account;
import nightplex.services.account.AccountInformationService;
import nightplex.services.notification.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


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
    private AccountInformationService accountInformationService;

    @Autowired
    private NotificationService notificationService;

    @RequestMapping("/game")
    public String gamePage(Model model) {

        Account account = accountInformationService.getCurrentAccount();

        model.addAttribute("userAccount", account);

        if (!account.getBarkeeping().isBarIsClosed()) {
            if (account.getBarkeeping().getDrinks() <= 0) {
                notificationService.addErrorMessage("Lack of drinks", "Close bar or make more drinks, otherwise reputation will fall!");
            }
        }
        return "game";

    }

}
