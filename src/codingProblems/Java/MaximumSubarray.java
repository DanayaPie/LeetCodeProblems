package codingProblems.Java;

public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];
            max = Math.max(sum, max); // return greatest value

            if (sum < 0) {
                sum = 0; // reset sum to 0 when sum += nums[i] = neg
            }
        }
        return max;
    }

//     // also print out the "start and end indexes"
//     public static int maxSubArray(int[] nums) {
//
//         int sum = 0;
//         int max = Integer.MIN_VALUE;
//
//         int startIndex = -1;
//         int tempStartIndex = -1;
//         int endIndex = -1;
//
//         for (int i = 0; i < nums.length; i++) {
//
//             sum += nums[i];
//             if (sum > max) {
//                 endIndex = i;
//                 startIndex = tempStartIndex;
//             }
//
//             max = Math.max(sum, max); // return greatest value
//
//             if (sum < 0) {
//                 sum = 0; // reset sum to 0 when sum += nums[i] = neg
//                 tempStartIndex = i + 1;
//             }
//         }
//
//         System.out.println("start index: " + startIndex + ", end index: " + endIndex);
//         return max;
//     }
}
