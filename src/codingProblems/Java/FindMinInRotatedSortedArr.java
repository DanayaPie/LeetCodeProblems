package codingProblems.Java;

public class FindMinInRotatedSortedArr {

    public static void main(String args[]) {

        int[] nums = {11, 13, 15, 17};

        System.out.println(findMin(nums));
    }

    /**
        Two Pointers
        TC: O(n log n)
     */
    public static int findMin(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        int mostMin = Integer.MAX_VALUE;

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            if (nums[left] < nums[right]) {

                mostMin = Math.min(mostMin, nums[left]);
                right--;
            } else {

                mostMin = Math.min(mostMin, nums[right]);
                left++;
            }
        }

        return mostMin;
    }
}
