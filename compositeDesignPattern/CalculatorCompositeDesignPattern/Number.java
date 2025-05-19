package CalculatorCompositeDesignPattern;

public class Number implements ArithmeticExpression{
    int value;
    public Number(int number){
        this.value=number;
    }

    @Override
    public int evaluate() {
        System.out.println("Number Value is "+value);
        return value;
    }
}
