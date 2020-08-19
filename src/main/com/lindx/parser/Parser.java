package main.com.lindx.parser;

import main.com.lindx.calc.RomanConstraint;
import main.com.lindx.converter.Converter;
import main.com.lindx.calc.Constraints;

public class Parser {

    private String expression;
    private boolean roman_flag = false;

    Converter converter = new Converter();

    public String parse(final String exp) {

        this.expression = cleanSpaces(exp);

        Result result = plusMinus(this.expression);

        if(roman_flag)
            return converter.toRoman(result.accomulator);
        
        return String.valueOf(result.accomulator);    
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

        while (++idx < exp.length() && !(Constraints.signs.contains(exp.charAt(idx))));
         
        String arg = exp.substring(0, idx);
        String rem = exp.substring(idx, exp.length());

        try {
            if(Constraints.romans.contains(RomanConstraint.valueOf(arg)))
            roman_flag = true;
        } catch (IllegalArgumentException e) {
            roman_flag = false;
        }

        if(roman_flag)
            return new Result(converter.toArabic(arg), rem);
       
        return new Result(Integer.parseInt(arg), rem);
    }
}
    