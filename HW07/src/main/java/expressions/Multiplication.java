package expressions;

public class Multiplication implements BinaryExpression {
    private Expression left;
    private Expression right;

    public Multiplication(Expression l, Expression r) {
        left = l;
        right = r;
    }
    public Expression left() {
        return left;
    }
    public Expression right() {
        return right;
    }
    public int evaluate() {
        return left.evaluate() * right.evaluate();
    }
    public String toString() {
        return "(" + left.toString() + " * " + right.toString() + ")";
    }
}
