package miu.controller;


import miu.domain.Calculator;
import miu.service.CalculatorService;
import miu.validator.CalculatorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class CalculatorController {
    @Autowired
    CalculatorValidator validator;
    @Autowired
    CalculatorService calculatorService;

    @RequestMapping(value = {"/", "/calculator_input"}, method = RequestMethod.GET)
    public String inputCalculator(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("====== inputCalculator ======");
        return "calculator";
    }

    @RequestMapping(value = "/calculator_result", method = RequestMethod.POST)
    public String resultCalculator(Calculator calculator, HttpServletRequest req, HttpServletResponse res) {
        List<String> errors = validator.validate(calculator);
        if (errors.isEmpty()) {
            calculatorService.calculate(calculator);
            req.setAttribute("calculator", calculator);
            return "result";
        } else {
            req.setAttribute("errors", errors);
            req.setAttribute("calculator", calculator);
            return "calculator";
        }

    }
}