//package stringorarray;
//
//import java.util.HashSet;
//
//public class ThreeSum {
//
//    class Triplet{
//        int x,y,z;
//
//        public Triplet(int x, int y, int z) {
//            this.x = x;
//            this.y = y;
//            this.z = z;
//        }
//
//        @Override
//        public String toString() {
//            return "Triplet{" +
//                    "x=" + x +
//                    ", y=" + y +
//                    ", z=" + z +
//                    '}';
//        }
//    }
//
//    class Pair {
//        int x,y;
//
//        public Pair(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//
//        @Override
//        public String toString() {
//            return "Pair{" +
//                    "x=" + x +
//                    ", y=" + y +
//                    '}';
//        }
//    }
//
//    public Triplet getThreeSum(int[] arr, int sum) {
//
//        for (int i = 0; i < arr.length; i++) {
//
//            Pair pair;
//            HashSet<Integer> hashSet = new HashSet<>();
//            for (int j = 0; j < arr.length; j++) {
//                if(j!=i) {
//                    if(hashSet.contains(sum-arr[i])) {
//                        pair = new Pair(arr[i],sum-arr[i]);
//                    } else{
//                        hashSet.add(arr[i]);
//                    }
//                }
//            }
//        }
//
//    }
//
//
//    public static void main(String[] args) {
//        ThreeSum twoSum = new ThreeSum();
//        System.out.println(twoSum.getTwoInt(new int[]{10,7,1,2}, 17));
//    }
//}
