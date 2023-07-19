package codingProblems.Java;

import java.util.HashMap;

public class MinimumWindowSubstring {

    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));
    }

    /**
     * Sliding Windows - HashMap
     * TC: O(n), n is length of s
     * SC: O(m), m is length of t
     */
    public static String minWindow(String s, String t) {

        if (t.length() > s.length() || t.length() == 0) {
            return "";
        }

        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;
        int lEnd = 0;
        int matchedCount = 0;

        HashMap<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        for (int rEnd = 0; rEnd < s.length(); rEnd++) {

            char rChar = s.charAt(rEnd);
            if (targetMap.containsKey(rChar)) {

                targetMap.put(rChar, targetMap.get(rChar) - 1);
                if (targetMap.get(rChar) == 0) { // only count if rChar is down to zero
                    matchedCount++;
                }
            }

            while (matchedCount == targetMap.size()) { // targetMap.size() does not consider dup char

                int currentLen = rEnd - lEnd + 1;
                if (currentLen < minLen) {

                    minLen = currentLen;
                    startIndex = lEnd;
                }

                char lChar = s.charAt(lEnd);
                if (targetMap.containsKey(lChar)) {

                    if (targetMap.get(lChar) == 0) { // if lChar is not zero, dont count
                        matchedCount--;
                    }

                    targetMap.put(lChar, targetMap.get(lChar) + 1);
                }

                lEnd++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }

    /**
     * Sliding Windows - 2 HashMap
     * TC: O(n), n is length of s
     * SC: O(2m), m is length of t
     */
//    public static String minWindow(String s, String t) {
//
//        if (t.length() > s.length()) {
//            return "";
//        }
//
//        int startIndex = -1;
//        int minLen = Integer.MAX_VALUE;
//        int lEnd = 0;
//
//        int needCount = t.length();
//        int haveCount = 0;
//        HashMap<Character, Integer> needMap = new HashMap<>();
//        HashMap<Character, Integer> haveMap = new HashMap<>();
//
//        for (char c : t.toCharArray()) {
//
//            needMap.put(c, needMap.getOrDefault(c, 0) + 1);
//        }
//
//        for (int rEnd = 0; rEnd < s.length(); rEnd++) {
//
//            char rightChar = s.charAt(rEnd);
//            if (needMap.containsKey(rightChar)) {
//
//                haveMap.put(rightChar, haveMap.getOrDefault(rightChar, 0) + 1);
//                if (haveMap.get(rightChar) <= needMap.get(rightChar)) {
//                    haveCount++;
//                }
//            }
//
//            while (haveCount == needCount) {
//
//                int currentLen = rEnd - lEnd + 1;
//                if (currentLen < minLen) {
//
//                    minLen = currentLen;
//                    startIndex = lEnd;
//                }
//
//                char leftChar = s.charAt(lEnd);
//                if (haveMap.containsKey(leftChar)) {
//
//                    haveMap.put(leftChar, haveMap.get(leftChar) - 1);
//                    if (haveMap.get(leftChar) < needMap.get(leftChar)) {
//                        haveCount--;
//                    }
//                }
//
//                lEnd++;
//            }
//        }
//        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
//    }
}
