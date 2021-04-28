package jm.calc.task.calc;

import java.util.Scanner;

public class Calculator {

  private Scanner in;
  private String expression;

  public Calculator() {

  }

  public void getExpression() {

    in = new Scanner(System.in);

    this.expression = in.nextLine();

    try {
      checkFormatExpression(this.expression);
    } catch (IllegalArgumentException | StringIndexOutOfBoundsException e) {
      System.err.print("-> Illegal format math expression . . .\n");
      System.exit(1);
    }

    in.close();
  }

  private boolean checkFormatExpression(final String exp) {

    System.out.println("get :" + exp);

    return false;
  }
}
