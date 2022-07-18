package codingProblems;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingChar {

    public static void main(String[] args) {

        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {

        HashSet<Character> hsChar = new HashSet<>();
        int length = 0;
        int toDelete = 0;

        for (int i = 0; i < s.length(); i++) {

            if (!hsChar.contains(s.charAt(i))) {
                hsChar.add(s.charAt(i));

                length = Math.max(hsChar.size(), length);

            } else {
                while (toDelete <= i && hsChar.contains(s.charAt(i))) {
                    hsChar.remove(s.charAt(toDelete));
                    ++toDelete;
                }
                hsChar.add(s.charAt(i));
            }
        }
        return length;
    }
}
