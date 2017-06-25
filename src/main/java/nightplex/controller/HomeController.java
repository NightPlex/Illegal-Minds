package nightplex.controller;

import nightplex.model.template.RegisterForm;
import nightplex.services.account.AccountInformationService;
import nightplex.services.notification.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String landingPage(RegisterForm registerForm) {

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
