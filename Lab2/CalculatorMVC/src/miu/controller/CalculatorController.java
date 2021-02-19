package miu.controller;


import miu.domain.Calculator;
import miu.validator.CalculatorValidator;
import mum.edu.framework.annotation.AutoWired;
import mum.edu.framework.annotation.Controller;
import mum.edu.framework.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@Controller
public class CalculatorController {
    @AutoWired
    CalculatorValidator validator;

    @RequestMapping(value = {"/", "/calculator_input"})
    public String inputCalculator(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("====== inputCalculator ======");
        return "/WEB-INF/jsp/calculator.jsp";
    }

    @RequestMapping(value = "/calculator_result")
    public String resultCalculator(Calculator calculator, HttpServletRequest req, HttpServletResponse res) {
        List<String> errors = validator.validate(calculator);
        if (errors.isEmpty()) {
            calculator.calculate();
            req.setAttribute("calculator", calculator);
            return "/WEB-INF/jsp/result.jsp";
        } else {
            System.out.println(Arrays.asList(errors).toString());
            req.setAttribute("errors", errors);
            req.setAttribute("calculator", calculator);
            return "/WEB-INF/jsp/calculator.jsp";
        }

    }
}
