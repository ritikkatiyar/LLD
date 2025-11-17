public class Expression implements ArithematicExpression{
    ArithematicExpression leftExpression;
    ArithematicExpression rightExpression;
    Operation operation;

    Expression(ArithematicExpression leftExpression,ArithematicExpression rightExpression,Operation operation){
        this.leftExpression=leftExpression;
        this.rightExpression=rightExpression;
        this.operation=operation;
    }
    @Override
    public int evaluate() {
        int val=0;
        switch (operation){
            case ADD :
                val= leftExpression.evaluate()+ rightExpression.evaluate();
                break;
            case DIVIDE :
                val= leftExpression.evaluate()/ rightExpression.evaluate();
                break;
            case MULTIPLY :
                val= leftExpression.evaluate()* rightExpression.evaluate();
                break;
            case SUBSTRACT :
                val= leftExpression.evaluate()- rightExpression.evaluate();
                break;
        }
        System.out.println("expression value is "+val);
        return val;
    }
}
