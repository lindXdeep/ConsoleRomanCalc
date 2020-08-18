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
        
        this.expression = cleanSpaces(exp);

        Result result = plusMinus(this.expression);

        


        System.out.println(result.accomulator);
        System.out.println(result.remainder_expression);
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

        if(current.remainder_expression != null) {

            char sign = current.remainder_expression.charAt(0);

            Result next = subNum(current.remainder_expression.substring(1));

            return new Result(
                (sign == '+') ? (current.accomulator += next.accomulator) : (current.accomulator -= next.accomulator), null);
        }
        return current;
    }

    private Result modDiv(final String exp) throws IllegalArgumentException {
        
        Result current = subNum(exp);

        char sign = current.remainder_expression.charAt(0);

        Result next = subNum(current.remainder_expression.substring(1));

        if(sign == '*' || sign == '/')       
            return new Result(
                (sign == '*') ? (current.accomulator *= next.accomulator) : (current.accomulator /= next.accomulator), null);

        return current;
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
    