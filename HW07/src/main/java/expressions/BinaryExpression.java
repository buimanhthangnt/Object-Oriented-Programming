package expressions;

public interface BinaryExpression extends Expression {
    Expression left();
    Expression right();
}
