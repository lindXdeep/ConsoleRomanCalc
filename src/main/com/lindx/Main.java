package main.com.lindx;

import main.com.lindx.calc.Calculator;
import main.com.lindx.converter.Converter;

public class Main {

    public static void main(String[] args) {

       Calculator calculator = new Calculator();

       

          
        
        calculator.getExpression();

            System.out.println("\nOutput: \n");

            System.out.println(calculator.getResult());

           
    }
}