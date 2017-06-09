package expressions;

public class Square implements Expression {
    private Expression expression;
    public Square(Expression e) {
        expression = e;
    }
    public int evaluate() {
        return expression.evaluate() * expression.evaluate();
    }
    public String toString() {
        return expression.toString() + "^" + 2;
    }
}
