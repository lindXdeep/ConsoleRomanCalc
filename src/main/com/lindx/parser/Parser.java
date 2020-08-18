package main.com.lindx.parser;

import java.net.IDN;
import java.util.HashMap;
import java.util.Map;

import main.com.lindx.calc.Roman;
import main.com.lindx.calc.Types;

public class Parser {

    private boolean roman_flag = false;

    private String expression;

    private Map<Roman, Integer> romans_map = new HashMap<>();  
   

    public void parse(final String exp) {

        for (int i = 0; i < Types.romans.size() ; i++)
            romans_map.put(Roman.values()[i], i+1);
        

        System.out.println(romans_map);

        this.expression = cleanSpaces(exp);

        Result result = plusMinus(this.expression);

        
        

    }

    private String cleanSpaces(final String exp){

        String[] tmp = exp.split(" ");  

        StringBuilder str = new StringBuilder();     

        if(tmp.length > 1)
            for (int i = 0; i < tmp.length; i++) 
                str.append(tmp[i]);               

        return new String( str.toString());
    }

    private Result plusMinus(final String exp) {

        Result current = modDiv(exp);

        //System.out.println(current.accomulator);
       // System.out.println(current.remainder_expression);

        return null;
    }

    private Result modDiv(final String exp) throws IllegalArgumentException {
        
        Result current = subNum(exp);

        char sign = current.remainder_expression.charAt(0);

        Result next = subNum(current.remainder_expression.substring(1));

        System.out.println("1: " + current.accomulator);
        System.out.println("2: " + sign);
        System.out.println("4: " + next.accomulator);


        // if(Types.signs.contains(sign)){

        //     if(sign == '*')
        //         current.accomulator *= Integer.parseInt(next);
        //     if(sign == '/')
        //         current.accomulator /= Integer.parseInt(next);

        // }else{
        //     throw new IllegalArgumentException();
        // }

        return null; //new Result(current.accomulator, null);
    }

    private Result subNum(final String exp) {

        int idx = 0;

        while (++idx < exp.length() && !(Types.signs.contains(exp.charAt(idx))));
         
        String arg = exp.substring(0, idx);
        String rem = exp.substring(idx, exp.length());

        try {
            if(Types.romans.contains(Roman.valueOf(arg)))
            roman_flag = true;
        } catch (IllegalArgumentException e) {
            roman_flag = false;
        }
    
        if(roman_flag)
            return new Result(romans_map.get(Roman.valueOf(arg)), rem);
       
        return new Result(Integer.parseInt(arg), rem);
    }
}
    