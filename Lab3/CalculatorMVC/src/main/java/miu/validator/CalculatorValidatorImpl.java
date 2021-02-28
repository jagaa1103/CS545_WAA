package miu.validator;


import miu.domain.Calculator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculatorValidatorImpl implements CalculatorValidator {

    @Override
    public List<String> validate(Object object) {
        List<String> errors = new ArrayList<>();
        Calculator calculator = (Calculator) object;
        String add1 = calculator.getAdd1();
        if (add1 == null || add1.trim().isEmpty()) {
            errors.add("Calculator must have add1");
        } else if (!checkStringToInteger(add1)) {
            errors.add("Need to insert valid number");
        }

        String add2 = calculator.getAdd2();
        if (add2 == null || add2.trim().isEmpty()) {
            errors.add("Calculator must have add2");
        } else if (!checkStringToInteger(add2)) {
            errors.add("Need to insert valid number");
        }

        String multi1 = calculator.getMulti1();
        if (multi1 == null || multi1.trim().isEmpty()) {
            errors.add("Calculator must have multi1");
        } else if (!checkStringToInteger(multi1)) {
            errors.add("Need to insert valid number");
        }

        String multi2 = calculator.getMulti2();
        if (multi2 == null || multi2.trim().isEmpty()) {
            errors.add("Calculator must have multi2");
        } else if (!checkStringToInteger(multi2)) {
            errors.add("Need to insert valid number");
        }

        return errors;
    }

    private boolean checkStringToInteger(String str){
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
