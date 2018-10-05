package stringorarray;

import java.math.BigInteger;

public class Factorial {

    public static BigInteger factorial(int n) {
        if(n==0) return BigInteger.valueOf(1);
        return BigInteger.valueOf(n).multiply(factorial(n-1));
    }

    public static BigInteger factorial2(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(factorial(12345).equals(factorial2(12345)));
    }
}
