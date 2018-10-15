package stringorarray;

import java.util.HashSet;

public class TwoSum {

    class Pair {
        int x,y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public Pair getTwoInt(int[] arr, int sum) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if(hashSet.contains(sum-arr[i])) {
                return new Pair(arr[i],sum-arr[i]);
            } else{
                hashSet.add(arr[i]);
            }
        }
        return null;
    }


    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(twoSum.getTwoInt(new int[]{10,7,1,2}, 17));
    }
}
