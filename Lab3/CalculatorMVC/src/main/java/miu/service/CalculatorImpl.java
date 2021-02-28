package miu.service;

import miu.domain.Calculator;
import org.springframework.stereotype.Service;

@Service
public class CalculatorImpl implements CalculatorService {

    @Override
    public void calculate(Calculator calculator) {
        calculator.calculate();
    }
}
