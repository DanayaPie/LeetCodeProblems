package codingProblems.Java;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(groupAnagrams(strs));
    }

    /**
     * HashMap - sorted char
     * TC: O(n * k log k), n is number of strings in strs, k is max length of string
     * - sorting take O(k log k)
     * - inserting can take up to O(k) due to potential collisions
     * SC: O(n * k), n is the number of strings in strs, k is max length of string
     */
    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {

            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String signatureChar = new String(chars);

            if (!map.containsKey(signatureChar)) {

                map.put(signatureChar, new ArrayList<>());
            }

            map.get(signatureChar).add(word);
        }

        return new ArrayList<>(map.values());
    }

    /**
     * HashMap - hash frequency (string representation of char)
     * TC: O(n * k log k), n is number of strings in strs due to concatenation, k is max length of string
     * - string concatenation of each string can be relatively slower
     * TC: O(n * k)
     */
//    public static List<List<String>> groupAnagrams(String[] strs) {
//
//        Map<String, List<String>> resMap = new HashMap<>();
//
//        for (String word : strs) {
//
//            int[] hash = new int[26];
//
//            for (char c : word.toCharArray()) {
//
//                hash[c - 'a']++; // hash char to ASCII value where 'a' is hash[0]
//            }
//
//            // string concatenation - convert int[] to  key of 0 and 1 if character exist
//            String key = Arrays.toString(hash);
//
//            if (!resMap.containsKey(key)) {
//
//                resMap.put(key, new ArrayList<>());
//            }
//
//            resMap.get(key).add(word); // add word to ArrayList w same key
//
//            System.out.println(key);
//        }
//
//        return new ArrayList<>(resMap.values());
//    }
}
