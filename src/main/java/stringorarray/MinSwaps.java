package stringorarray;

import java.util.Arrays;

public class MinSwaps {
    static int minimumSwaps(int[] arr) {
        int arrLen = arr.length;
        int count = 0;
        Boolean[] swappedArray= new Boolean[arr.length];
        int [] sarr = arr.clone();
        Arrays.sort(sarr);

        for (int i = 0; i < arrLen; i++) {
            Arrays.fill(swappedArray,false);
            if (arr[i] != sarr[i]) {
                swappedArray[i] = true;
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
            if(!Arrays.asList(swappedArray).contains(true)) {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minimumSwaps(new int[]{1,3,5,2,4,6,8}));
    }
}
