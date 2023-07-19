package codingProblems.Java;

import java.util.HashMap;

public class LongestSubstringLenWithKDistinctChar {

    public static void main(String[] args) {

        String s = "AAAHHIBC";
        int k = 2;

        System.out.println(substringLen(s, k));
    }

    /**
     * Sliding Window - hashMap
     * TC: O(n)
     */
    public static int substringLen(String s, int k) {

        HashMap<Character, Integer> charMap = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        int lEnd = 0;

        for (int rEnd = 0; rEnd < s.length(); rEnd++) {

            char rightChar = s.charAt(rEnd);

            charMap.put(rightChar, charMap.getOrDefault(rightChar, 0) + 1);

            while (charMap.size() > k) {

                char leftChar = s.charAt(lEnd);

                charMap.put(leftChar, charMap.get(leftChar) - 1);

                if (charMap.get(leftChar) == 0) {

                    charMap.remove(leftChar);
                }

                lEnd++;
            }

            maxLen = Math.max(maxLen, rEnd - lEnd + 1);
        }

        return maxLen;
    }
}
