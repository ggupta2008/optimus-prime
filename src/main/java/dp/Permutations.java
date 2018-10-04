package dp;

import java.util.*;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        System.out.println("listoflist ==> " + list + "  templist ==> " + tempList + "originalnums ==> " + Arrays.toString(nums));
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public List<List<Integer>> subsets(int[] a) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, a.length); i++) {
            List<Integer> tempList = new ArrayList<>();
            for (int j = 0; j < a.length; j++) {
                if ((i & (1 << j)) > 0) {
                    tempList.add(a[j]);
                }
            }
            result.add(tempList);
        }
        return result;
    }

    public List<Integer> longestPalindrome(int[] nums) {
        List<List<Integer>> allSubsets = subsets(nums);
        allSubsets.sort((m1, m2) -> {
            if (m1.size() == m2.size()) {
                return 0;
            }
            return m1.size() > m2.size() ? -1 : 1;
        });
        System.out.println(allSubsets);
        return null;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 1};
//        System.out.println(new dp.Permutations().subsets(a));
//        System.out.println(new dp.Permutations().permute(a));
        System.out.println(new Permutations().longestPalindrome(a));
    }
}
