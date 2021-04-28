package jm.calc.task.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Constraints
 */
public class Constraints {

  public static Collection<Character> signs =

                            new ArrayList<>(Arrays.asList('+', '-','/','*'));

  public static Collection<RomanConstraint> romans =
  
                            new ArrayList<>(Arrays.asList(RomanConstraint.values()));
}