package CalculatorCompositeDesignPattern;

public class Expression implements ArithmeticExpression{
    ArithmeticExpression leftExpression;
    ArithmeticExpression rightExpression;
    Operation operation;


    public Expression(ArithmeticExpression leftPart){

    }
    @Override
    public int evaluate() {
        return 0;
    }
}
