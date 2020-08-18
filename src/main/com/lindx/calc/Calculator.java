package main.com.lindx.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

import main.com.lindx.parser.Parser;

public class Calculator {
    
    private Scanner in;
    private String expression;
    private Parser parser; 

    Collection<Character> signs;
    Collection<Roman> romans;
   
    public Calculator(){
        signs = new ArrayList<>(Arrays.asList('+', '-','/','*'));
        romans = new ArrayList<>(Arrays.asList(Roman.values()));
        parser = new Parser();

        System.out.println("Input:\n" );
    };

    public void getExpression() {

        in = new Scanner(System.in);

        this.expression = in.nextLine();

        try {
            checkFormatExpression(this.expression);               
        }catch(IllegalArgumentException | StringIndexOutOfBoundsException e){
            System.err.print("-> Illegal format math expression . . .\n");
            System.exit(1);
        }
        
        in.close();

        parser.parse(this.expression.trim());
    }

    public String getResult() {
        return expression;
    }

    public void showResult() {
        System.out.println("\nOutput: \n");
        System.out.println(expression);
    }

    private boolean checkFormatExpression(final String exp) {

        int idx = 0;

        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();

        while (!signs.contains(exp.charAt(idx)))     
            left.append(exp.charAt(idx++)).trimToSize();
        idx++;   
        while(idx < exp.length())
            right.append(exp.charAt(idx++)).trimToSize();   

        String a = left.toString().trim();
        String b = right.toString().trim();

        if(Character.isDigit(a.charAt(0))){
            if( (Integer.parseInt(a) > 0 && Integer.parseInt(a) <= 10) && (Integer.parseInt(b) > 0 && Integer.parseInt(b) <= 10))
                return true;
        }
        if(romans.contains(Roman.valueOf(a)) && romans.contains(Roman.valueOf(b)))
            return true;       
        return false;
    }
}