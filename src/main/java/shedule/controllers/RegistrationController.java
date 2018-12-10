package shedule.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import shedule.domain.MyUser;
import shedule.service.UserService;

import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }


    @PostMapping("/registration")
    public String addUser(MyUser user, Map<String, Object> model) {

        if (!userService.addUser(user)) {
            model.put("message", "user exist");
            return "registration";
        }

        return "redirect:/login";
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code) {
        boolean isActivated = userService.activateUser(code);
        if(isActivated) {
            model.addAttribute("message", "Account successfully activate ");
        } else {
            model.addAttribute("message", "Activation account not found");
        }

        return "redirect:/login";
    }
}
