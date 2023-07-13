package codingProblems.Java;

public class SearchInRotatedSortedArr {

    public static void main(String[] args) {

        int[] nums = {4,5,6,7,0,1,2};
        int target = 7;

        System.out.println(indexTarget(nums, target));
    }

    /**
        Two Pointers
        TC: O(n log n)
     */
    public static int indexTarget(int[] nums, int target) {

        if (nums.length == 1 && target != nums[0]) {

            return -1;
        } else if (nums.length == 1 && target == nums[0]) {

            return 0;
        }

        int res = -1;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            if (nums[left] == target) {
                return left;
            }
            if (nums[right] == target) {
                return right;
            }

            left++;
            right--;
        }

        return res;
    }
}
