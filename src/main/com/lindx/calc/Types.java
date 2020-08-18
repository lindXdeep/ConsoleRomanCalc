package main.com.lindx.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Types {
    public static Collection<Character> signs = new ArrayList<>(Arrays.asList('+', '-','/','*'));
    public static Collection<Roman> romans = new ArrayList<>(Arrays.asList(Roman.values()));
}
