package test.com.lindx;

import main.com.lindx.calc.Calculator;

public class TestMain {
    
    public static void main(String[] args) {

        Calculator calculator =  new Calculator();

            calculator.getExpression();

            System.out.println(calculator.getResult());

            calculator.showResult();
    }
}