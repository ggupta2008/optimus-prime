package stringorarray;

import java.util.Arrays;

public class MinSwaps {
    static int minimumSwaps(int[] arr) {
        int arrLen = arr.length;
        int count = 0;
        int [] sarr = arr.clone();
        Arrays.sort(sarr);

        for (int i = 0; i < arrLen; i++) {
            if (arr[i] != sarr[i]) {
                count++;
                for (int j = i + 1; j < arrLen; j++) {
                    if (arr[j] == sarr[i] ) {
                        int tmp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = tmp;
                        break;
                    }
                }
            }
            System.out.println(Arrays.toString(arr));
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minimumSwaps(new int[]{8,7,1,3,2,4,5,6}));
    }
}
