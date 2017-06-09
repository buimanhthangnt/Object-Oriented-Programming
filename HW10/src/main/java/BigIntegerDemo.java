import java.security.InvalidParameterException;

public class BigIntegerDemo {
    public static void main(String[] args) {
        try {
            BigInteger bigInt1 = new BigInteger("-1111111");
            BigInteger bigInt2 = new BigInteger(99);
            BigInteger bigInt3 = new BigInteger("-11111110");
            BigInteger bigInt4 = new BigInteger(98);
            System.out.println(bigInt1.subtract(bigInt2).toString());
            System.out.println(bigInt1.add(bigInt2).toLong());
            System.out.println(bigInt1.clone().toString());
            System.out.println(bigInt1.compareTo(bigInt3));
            System.out.println(bigInt2.compareTo(bigInt4));
            System.out.println(bigInt2.compareTo(bigInt3));
        }
        catch (InvalidParameterException ipe) {
            System.out.println("String input is invalid!!!");
        }
    }
}
