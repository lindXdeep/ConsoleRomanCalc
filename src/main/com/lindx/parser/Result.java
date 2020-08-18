package main.com.lindx.parser;

public class Result<T> {
    
    T accomulator;
    String remainder_expression;

    public Result(final T acc, final String exp) {
        this.accomulator = acc;
        this.remainder_expression = exp;
    }
}