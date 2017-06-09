package expressions;

public class Numeral implements Expression{
    private int value;
    public Numeral(int v) {
        value = v;
    }
    public int evaluate() {
        return value;
    }
    public String toString() {
        return Integer.toString(value);
    }
}
