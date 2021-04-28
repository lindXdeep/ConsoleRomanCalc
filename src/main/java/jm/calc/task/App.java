package jm.calc.task;

import jm.calc.task.calc.Calculator;

public class App{

  private static Calculator calculator;
  public static void main(String[] args) {

    calculator = new Calculator();

    System.out.println("Input:\n" );

    calculator.getExpression();

  
  }
}