package main.com.lindx;

import main.com.lindx.calc.Calculator;

public class Main {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        System.out.println("Input:\n" );
        
        calculator.getExpression();

        System.out.println("\nOutput: \n");

        System.out.println(calculator.getResult());
    }
}