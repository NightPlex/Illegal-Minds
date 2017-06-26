package nightplex.controller;

import nightplex.model.Account;
import nightplex.model.template.RegisterForm;
import nightplex.services.account.AccountInformationService;
import nightplex.services.notification.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

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
    private AccountInformationService accountInformationService;

    @RequestMapping("/")
    public String landingPage(RegisterForm registerForm, Model model) {

        //If user is already logged in cannot see the main page unless logs out.
        if(SecurityContextHolder.getContext().getAuthentication() != null &&
                SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
                //when Anonymous Authentication is enabled
                !(SecurityContextHolder.getContext().getAuthentication()
                        instanceof AnonymousAuthenticationToken) ) {
            Account account = accountInformationService.getCurrentAccount();

            model.addAttribute("userAccount", account);

            if (!account.getBarkeeping().isBarIsClosed()) {
                if (account.getBarkeeping().getDrinks() <= 0) {
                    nService.addErrorMessage("Lack of drinks", "Close bar or make more drinks, otherwise reputation will fall!");
                }
            }
            return "game";
        }

        return "index";

    }

    @RequestMapping("/login")
    public String login() {
        System.out.println("test");
        return "index";

    }

    // Give registerForm object to the method and fill it with data.
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid RegisterForm registerForm, BindingResult result) {

        if (result.hasErrors()) {

            nService.addErrorMessage("Error", "Check your registration form");
            return "index";
        }
        // check if the password and email are the same(type twice)
        if (registerForm.getPassword().equals(registerForm.getAgainPassword()) || registerForm.getEmail().equals(registerForm.getAgainEmail())) {

            accountInformationService.registerNewAccount(registerForm.getUsername(), registerForm.getPassword(), registerForm.getEmail());
            nService.addSuccessMessage("Congratz", "You have successfully registered as member, you may log in!");
            return "redirect:/";

        } else {
            nService.addErrorMessage("Error", "Email or password does not match");
            return "index";

        }

    }

}
