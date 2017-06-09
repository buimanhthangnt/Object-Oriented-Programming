import java.security.InvalidParameterException;

public class BigInteger {
    private String bigNum;

    public BigInteger(long init) {
        bigNum = Long.toString(init);
    }

    public BigInteger(String init) throws InvalidParameterException {
        char[] temp = init.toCharArray();
        int start = 0;
        String tempNum = "";
        if (temp[0] == '+' || temp[0] == '-') {
            if (temp[0] == '-') tempNum = '-' + tempNum;
            start = 1;
        }
        while (start < init.length() && temp[start] == '0') start++;
        for (int i = start; i < init.length(); i++) {
            if (temp[i] > 47 && temp[i] < 58) tempNum += temp[i];
            else throw new InvalidParameterException();
        }
        if (tempNum == "") tempNum = "0";
        bigNum = tempNum;
    }

    public String toString() {
        return bigNum;
    }

    public boolean equals(Object other) {
        if (!(other instanceof BigInteger)) return false;
        int l1 = bigNum.length(), l2 = ((BigInteger) other).bigNum.length();
        char[] num1 = bigNum.toCharArray();
        char[] num2 = ((BigInteger) other).bigNum.toCharArray();
        boolean equal = true;
        if (l1 != l2) return false;
        else {
            for (int i = 0; i < l1; i++) {
                if (num1[i] != num2[i]) {
                    equal = false;
                    break;
                }
            }
            return equal;
        }
    }

    public long toLong() {
        return Long.parseLong(bigNum);
    }

    private BigInteger convertToPositive() {
        char[] temp = this.bigNum.toCharArray();
        String newString = "";
        for (int i = 1; i < bigNum.length(); i++) {
            newString += temp[i];
        }
        return new BigInteger(newString);
    }

    private BigInteger convertToNegative() {
        String newString = "-" + bigNum;
        return new BigInteger(newString);
    }

    public BigInteger add(BigInteger other) {
        String result = "";
        char[] num1 = bigNum.toCharArray();
        char[] num2 = (other.bigNum).toCharArray();
        boolean bothIsNegative = false;
        if (num1[0] == '-' && num2[0] == '-') {
            bothIsNegative = true;
            num1 = this.convertToPositive().bigNum.toCharArray();
            num2 = other.convertToPositive().bigNum.toCharArray();
        }
        if (num1[0] == '-' && num2[0] != '-') {
            BigInteger temp = this.convertToPositive();
            return other.subtract(temp);
        }
        if (num1[0] != '-' && num2[0] == '-') {
            BigInteger temp = other.convertToPositive();
            return this.subtract(temp);
        }
        int l1 = num1.length, l2 = num2.length;
        int max = (l1 > l2) ? l1 : l2;
        int remember = 0;
        for (int i = 1; i <= max; i++) {
            int n1 = (l1 - i >= 0) ? num1[l1 - i] - 48 : 0;
            int n2 = (l2 - i >= 0) ? num2[l2 - i] - 48 : 0;
            int sum = (n1 + n2 + remember) % 10;
            remember = (n1 + n2 + remember) / 10;
            result = Integer.toString(sum) + result;
        }
        if (remember == 1) result = '1' + result;
        if (bothIsNegative) result = "-" + result;
        return new BigInteger(result);
    }

    public BigInteger subtract(BigInteger other) {
        int l1 = bigNum.length(), l2 = other.bigNum.length();
        char[] num1 = bigNum.toCharArray();
        char[] num2 = (other.bigNum).toCharArray();
        if (num1[0] == '-' && num2[0] == '-') {
            return this.add(other.convertToPositive());
        }
        if (num1[0] != '-' && num2[0] == '-') {
            return this.add(other.convertToPositive());
        }
        if (num1[0] == '-' && num2[0] != '-') {
            return this.add(other.convertToNegative());
        }
        boolean isBigger = true;
        if (l2 > l1 || (l2 == l1 && num1[0] < num2[0])) isBigger = false;
        int max = (l1 > l2) ? l1 : l2;
        String result = "";
        int remember = 0;
        for (int i = 1; i <= max; i++) {
            int n1 = (l1 - i >= 0) ? num1[l1 - i] - 48 : 0;
            int n2 = (l2 - i >= 0) ? num2[l2 - i] - 48 : 0;
            int temp = (isBigger) ? (n1 - n2 - remember) : (n2 - n1 - remember);
            if (temp < 0) {
                temp += 10;
                remember = 1;
            } else remember = 0;
            result = Integer.toString(temp) + result;
        }
        if (!isBigger) result = "-" + result;
        return new BigInteger(result);
    }

    public int compareTo(BigInteger other) {
        int l1 = bigNum.length(), l2 = other.bigNum.length();
        char[] num1 = bigNum.toCharArray();
        char[] num2 = other.bigNum.toCharArray();
        int compare = 0;
        if (num1[0] == '-' && num2[0] != '-') return -1;
        if (num1[0] != '-' && num2[0] == '-') return 1;
        if (l1 > l2) return 1;
        if (l2 > l1) return -1;
        for (int i = 0; i < l1; i++) {
            if (num1[i] > num2[i]) compare = (num1[0] != '-') ? 1 : -1;
            else if (num1[i] < num2[i]) compare = (num1[0] != '-') ? -1 : 1;
            if (compare != 0) break;
        }
        return compare;
    }

    public BigInteger clone() {
        String newString = "";
        char[] temp = bigNum.toCharArray();
        for (int i = 0; i < bigNum.length(); i++) {
            newString = newString + temp[i];
        }
        return new BigInteger(newString);
    }
}
