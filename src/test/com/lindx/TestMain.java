package test.com.lindx;

import main.com.lindx.calc.Calculator;

public class TestMain {
    
    public static void main(String[] args) {

        String str1 = "1 \n + 3";
        String str2 = "1 + \n 3";
        
        Calculator calculator =  new Calculator();

            calculator.getExpression();

            
       

    }

    
}