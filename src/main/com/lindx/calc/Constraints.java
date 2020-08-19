package main.com.lindx.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Constraints {
    public static Collection<Character> signs = new ArrayList<>(Arrays.asList('+', '-','/','*'));
    public static Collection<RomanConstraint> romans = new ArrayList<>(Arrays.asList(RomanConstraint.values()));
}
