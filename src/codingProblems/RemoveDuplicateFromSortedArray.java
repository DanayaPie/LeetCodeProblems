package codingProblems;

public class RemoveDuplicateFromSortedArray {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 4, 6};

        System.out.println(removeDuplicates(nums));
    }

    // while loop
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                i = i + 1;
                nums[i] = nums[j];
                j++;
            }
        }
        return i + 1;
    }

//    // for loop
//     public static int removeDuplicates(int[] nums) {
//
//         int noneDup = 1;
//         for (int i = 1; i < nums.length; i ++) {
//             if (nums[i] != nums[i-1]) {
//                 nums[noneDup] = nums[i]; // rearrange array
//                 noneDup++;
//             }
//         }
//         return noneDup;
//     }
}
