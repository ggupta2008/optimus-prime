package string;

import java.util.Arrays;

public class Fibonacci {

    static int[] fib(int n) {
        /* Declare an array to store string.Fibonacci numbers. */
        int f[] = new int[n + 1]; // 1 extra to handle case, n = 0
        int i;

        /* 0th and 1st number of the series are 0 and 1*/
        f[0] = 0;
        f[1] = 1;

        for (i = 2; i <= n; i++) {
       /* Add the previous 2 numbers in the series
         and store it */
            f[i] = f[i - 1] + f[i - 2];
        }

        return f;
    }


    static int fib2(int n) {
        int a = 0, b = 1, c;
        if (n == 0)
            return a;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String args[]) {
        int n = 9;
        System.out.println(Arrays.toString(fib(n)));
    }

}
