package codingProblems.Java;

import java.util.HashMap;

public class FirstUniqueCharInString {

    public static void main(String[] args) {

        String s = "papayabanana";

        System.out.println(findUniqChar(s));
    }

    /**
     * Array Mapping with Character Frequency Count
     * TC: O(n), n is length of character
     * - iterating through constant array of 26 is O(26) which is O(1)
     * SC: O(1), utilize two constant arrays, array size 26 and auxiliary array
     */
    public static int findUniqChar(String s) {

        int[] charFreq = new int[26];
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {

            int index = charArray[i] - 'a';

            if (charFreq[index] == 0) { // if 0, then char is not seen yet
                charFreq[index] = i + 1;
            } else {
                charFreq[index] = -1; // if not 0, char is seen so set value to -1
            }
        }

        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {

            if (charFreq[i] > 0) {
                minIndex = Math.min(minIndex, charFreq[i] - 1);
            }
        }

        return minIndex == Integer.MAX_VALUE ? -1 : minIndex;
    }

    /**
     * HashMap - 2 for loops
     * TC: O(n) - worst case O(n^2) if have to traverse twice
     * SC: O(k), k is number of char in s
     */
//    public static int findUniqChar(String s) {
//
//        HashMap<Character, Integer> freqMap = new HashMap<>();
//
//        for (char c: s.toCharArray()) {
//
//            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
//        }
//
//        for (int i = 0; i < s.length(); i++) {
//
//            if (freqMap.get(s.charAt(i)) == 1) {
//                return i;
//            }
//        }
//
//        return -1;
//    }
}
