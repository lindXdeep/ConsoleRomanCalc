package main.com.lindx.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Parser {

    String expression;

    public void parse(final String exp) {
        
        this.expression = cleanSpaces(exp);

        



        

    }

    private String cleanSpaces(final String exp){

        String[] tmp = exp.split(" ");  

        StringBuilder str = new StringBuilder();     

        if(tmp.length > 1)
            for (int i = 0; i < tmp.length; i++) 
                str.append(tmp[i]);               

        return new String( str.toString());
    }
}
    