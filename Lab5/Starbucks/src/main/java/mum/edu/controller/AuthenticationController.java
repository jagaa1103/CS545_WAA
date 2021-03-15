package mum.edu.controller;

import mum.edu.model.User;
import mum.edu.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.HashMap;
import java.util.List;

@Controller
@SessionAttributes("user")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String handleGet() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String handlePost(User user, Model model) {
        if (authenticationService.checkUserAuthentication(user)) {
            model.addAttribute("user", user);
            return "redirect:/display";
        }
        else
            return "redirect:/";
    }
}
