package mum.edu.controller;

import mum.edu.model.User;
import mum.edu.repository.DataFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;


@Controller
@SessionAttributes("user")
public class AdviceController {

    @Autowired
    DataFacade dataFacade;

    @RequestMapping(value="/display", method = RequestMethod.GET)
    public String handleDisplay(Model model) {
        User user = (User)((ModelMap) model).get("user");
        if (user == null) {
            return "redirect:/";
        }
        return "display";
    }

    @RequestMapping(value = "/advice", method = RequestMethod.GET)
    public String handleGet(@RequestParam String roast, Model model) {
        ModelMap map = (ModelMap) model;
        User user = (User)map.get("user");
        if (user == null)
            return "redirect:/";
        List<String> advice = dataFacade.getAdvice(roast);
        model.addAttribute("roast", roast);
        model.addAttribute("advice", advice);
        return "advice";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String goBack(SessionStatus status){
        status.setComplete();
        return "redirect:/";
    }
}
