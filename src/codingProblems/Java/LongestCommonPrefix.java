package codingProblems.Java;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        String[] strs = {"flower", "floor", "flow", "flight"};

        System.out.println(longestCommonPrefix(strs));

    }

//     // not the fastest
//     public static String longestCommonPrefix(String[] strs) {

//         StringBuilder output = new StringBuilder();

//         if (strs == null || strs.length == 0) {
//             output.append("");
//         }

//         int index = 0;
//         for (char c: strs[0].toCharArray()) { // store char from strs[0] in c
//             // System.out.println(c);

//             for (int i = 1; i < strs.length; i++) {
//                 // if index is out of bounce or 2 chars dont match
//                 if (index >= strs[i].length() || c != strs[i].charAt(index)) {
//                     // return = break out of all the loops
//                     return output.toString();
//                 }
//             }
//             output.append(c);
//             index++;
//         }
//         return output.toString();
//     }

    // sort then compare - fast
    public static String longestCommonPrefix(String[] strs) {

        Arrays.sort(strs);
        int arrayLength = strs.length;

        // sorted array = compare first and last strings
        String first = strs[0];
        String last = strs[arrayLength - 1];

        for (int i = 0; i < first.length(); i++) {

            // return substring of first before the mismatch, if mismatch found
            if (first.charAt(i) != last.charAt(i)) {
                return first.substring(0, i);
            }
        }
        return first;
    }
}
