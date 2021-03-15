package miu.controller;


import miu.domain.Calculator;
import miu.service.CalculatorService;
import miu.validator.CalculatorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class CalculatorController {
    @Autowired
    CalculatorValidator validator;
    @Autowired
    CalculatorService calculatorService;

    @RequestMapping(value = {"/", "/calculator"}, method = RequestMethod.GET)
    public String inputCalculator(Model model) {
        return "calculator";
    }

    @RequestMapping(value = {"/result",}, method = RequestMethod.GET)
    public String getResult(Model model) {
        return "result";
    }

    @RequestMapping(value = "/calculator_result", method = RequestMethod.POST)
    public String resultCalculator(Calculator calculator, Model model, RedirectAttributes redirectAttributes) {
        List<String> errors = validator.validate(calculator);
        if (errors.isEmpty()) {
            calculatorService.calculate(calculator);
            redirectAttributes.addFlashAttribute(calculator);
            String[] messages = {"your input is successfully calculated.", "Please check result below."};
            redirectAttributes.addFlashAttribute(messages);
            return "redirect:/result";
        } else {
            redirectAttributes.addFlashAttribute("errors", errors);
            redirectAttributes.addFlashAttribute(calculator);
            return "redirect:/calculator";
        }
    }
}