package codingProblems.Java;

public class FindDupNumber {

    /*
        Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
            - length = n + 1
            - every value in the array is going to be between 1 and n

            Ex: len is 5, then value in the array is between 1 - 4

        - index 0 will never get pointed to, which mean index 0 is not part of the cycle
        - duplicate int will point to the same index twice

     */
    public static void main(String[] args) {

        int[] nums = {4, 3, 1, 2, 2};

        System.out.println(findDuplicate(nums));
    }

    /**
     * Floyd's Cycle Finding
     * TC: O(n)
     */
    public static int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[0];

        // phase 1
        do {

            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // phase 2: fast move only 1 step at a time (old slow)
        slow = nums[0];

        while (slow != fast) {

            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    private static int loopArray(int[] nums, int i) {

        System.out.println("before: " + i);

        if (i >= nums.length) {
            i = Math.abs(nums.length - i);
        }

        System.out.println("after: " + i);

        return i;
    }

    /**
     Brute Force - Nested For Loop
     TC: O(n^2)
     */
//    public static int findDuplicate(int[] nums) {
//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//
//                if (nums[i] == nums[j]) {
//                    return nums[i];
//                }
//            }
//        }
//
//        return -1;
//    }
}
