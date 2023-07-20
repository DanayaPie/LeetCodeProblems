package codingProblems.Java;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingChar {

    public static void main(String[] args) {

        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * Sliding Window - HashSet
     * TC: O(n)
     * SC: O(min(n,m)), m is the distinct char
     */
    public static int lengthOfLongestSubstring(String s) {

        int maxLength = 0;
        int lEnd = 0;
        int rEnd = 0;
        HashSet<Character> charSet = new HashSet<>();

        while (rEnd < s.length()) {

            if (charSet.contains(s.charAt(rEnd))) {

                charSet.remove(s.charAt(lEnd));
                lEnd++;
            } else {

                charSet.add(s.charAt(rEnd));
                maxLength = Math.max(maxLength, rEnd - lEnd + 1);
                rEnd++;
            }
        }

        return maxLength;
    }

    /**
     * Sliding Window - HashSet
     * TC: O(n) - worst case O(n^2) due to iterate toDelete
     * SC: O(min(n,m)), m is the distinct char
     */
//    public static int lengthOfLongestSubstring(String s) {
//
//        int maxLength = 0;
//        int toDelete = 0;
//        HashSet<Character> charSet = new HashSet<>();
//
//        for (int i = 0; i < s.length(); i++) {
//
//            char currentChar = s.charAt(i);
//
//            if (!charSet.contains(currentChar)) {
//
//                charSet.add(currentChar);
//                maxLength = Math.max(maxLength, charSet.size());
//            } else {
//
//                while (toDelete < i && charSet.contains(currentChar)) {
//
//                    charSet.remove(s.charAt(toDelete));
//                    toDelete++;
//                }
//
//                charSet.add(currentChar);
//            }
//
//        }
//
//        return maxLength;
//    }
}
