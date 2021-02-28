package mum.edu.controller;

import mum.edu.repository.DataFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdviceController {

    @Autowired
    DataFacade dataFacade;

    @RequestMapping(value = "/advice", method = RequestMethod.GET)
    public String handleGet(@RequestParam String roast, Model model) {
        System.out.println("=================== " + roast);
        List<String> advice = dataFacade.getAdvice(roast);
        model.addAttribute("roast", roast);
        model.addAttribute("advice", advice);
        return "advice";
    }

    @RequestMapping(value = "/back", method = RequestMethod.GET)
    public String goBack(){
        return "index";
    }
}
