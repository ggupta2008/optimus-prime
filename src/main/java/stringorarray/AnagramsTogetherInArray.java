package stringorarray;

import java.util.*;

//{"cat", "dog", "tac", "god", "act"}, then output may be "cat tac act dog god".
public class AnagramsTogetherInArray {
    // the strategy would be to use hashtable and hash all anagrams with same hash value
    // when retrieving we will print all elements with same hashvalue together
    private static HashMap<Integer, List<String>> returnClusteredAnagrams(String[] anagrams) {
        HashMap<Integer, List<String>> anagramMap = new HashMap<>();
        for (String anagram : anagrams) {
            int hashCode = hashCode(anagram);
            List<String> tempList = anagramMap.get(hashCode);
            if (tempList == null) {
                tempList = new ArrayList<>();
            }
            tempList.add(anagram);
            anagramMap.put(hashCode, tempList);
        }
        return anagramMap;
    }


    private static int hashCode(String string) {
        char[] chars = string.toCharArray();
        int sum = 0;
        for (char aChar : chars) {
            sum += aChar;
        }
        return sum;
    }

    public static void main(String[] args) {
        String[] anagrams = {"cat", "dog", "tac", "god", "act"};
        System.out.println(returnClusteredAnagrams(anagrams));
    }

}
