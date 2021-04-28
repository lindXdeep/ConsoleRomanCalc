package jm.calc.task.calc;

import java.util.Scanner;

import jm.calc.task.utils.Constraints;
import jm.calc.task.utils.RomanConstraint;

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

    System.out.println("result: " +  expression);
  }

  private boolean checkFormatExpression(final String exp) {

    int idx = 0;

    StringBuilder left = new StringBuilder();
    StringBuilder right = new StringBuilder();

    while (!Constraints.signs.contains(exp.charAt(idx)))
      left.append(exp.charAt(idx++)).trimToSize();

    idx++;

    while (idx < exp.length())
      right.append(exp.charAt(idx++)).trimToSize();

    String a = left.toString().trim();
    String b = right.toString().trim();

    if (Character.isDigit(a.charAt(0))) {

      if ((Integer.parseInt(a) > 0 && Integer.parseInt(a) <= 10)
          && (Integer.parseInt(b) > 0 && Integer.parseInt(b) <= 10))
        return true;
    }
    
    if (Constraints.romans.contains(RomanConstraint.valueOf(a))
        && Constraints.romans.contains(RomanConstraint.valueOf(b)))
      return true;
    return false;
  }
}
