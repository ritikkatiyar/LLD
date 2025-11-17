public class Number implements ArithematicExpression{
    int value;
    Number(int value){
        this.value=value;
    }
    @Override
    public int evaluate() {
        System.out.println("number value is "+value);
        return value;
    }
}
