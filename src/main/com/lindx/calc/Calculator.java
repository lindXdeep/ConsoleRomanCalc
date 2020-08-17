package main.com.lindx.calc;

import java.util.Scanner;

public class Calculator {
    
    private Scanner in;
    private String expression;

    public Calculator(){
        System.out.println("Input:\n" );
    };

    public void getExpression() {

        in = new Scanner(System.in);

        try {
            this.expression = in.nextLine();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getResult() {
        return expression;
    }

    public void showResult() {
        System.out.println("\nOutput: \n");
        System.out.println(expression);
    }
}