package stringorarray;

import java.util.Scanner;

public class NewYearChaos {
    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        // check for Chaos
        for(int i=0;i<q.length;i++) {
            if(q[i]-i-1>2) {
                System.out.println("Too chaotic");
                return;
            }
        }

        int swaps= 0;
        for(int i=0; i< q.length; i++) {
            for(int j=0; j< q.length-i-1; j++) {
                if(q[j] > q[j+1]){
                    int temp = q[j];
                    q[j] = q[j+1];
                    q[j+1] = temp;
                    swaps+=1;
                }
            }
        }
        System.out.println(swaps);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
