package codingProblems.Java;

import java.util.HashSet;

public class SingleNumber {

    /*-
        Ways:
            1. HashSet - TC and SC: O(n)
            2. Bitwise XOR operator (^) - TC: O(n), SC: O(1)
                    * also known as "eXclusive OR"
                - XOR computation: compare 2 binary representation return binary format that convert to decimal values
                - return 1 if the two values are different, else return 0
                - return value if 0 xor the value
     */

    public static void main(String args[]) {
        int[] nums = {3, 3, 1};

        System.out.println(singleNumber(nums));
    }

    // HashSet
//    private static int singleNumber(int[] nums) {
//
//        HashSet<Integer> uniqueNum = new HashSet<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            if (uniqueNum.contains(nums[i])) {
//                uniqueNum.remove(nums[i]);
//            } else {
//                uniqueNum.add(nums[i]);
//            }
//        }
//
//        return uniqueNum.iterator().next();
//    }

    // XOR Operator
    private static int singleNumber(int[] nums) {

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i]; // caret (^) or XOR Operator compare 2 values and set it to res
        }

        return res;
    }
}
