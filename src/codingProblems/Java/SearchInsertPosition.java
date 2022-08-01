package codingProblems.Java;

public class SearchInsertPosition {

    public static void main(String[] args) {

        int[] nums = {3, 4, 5, 6, 7, 8};
        int target = 0;
        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // prevent run time over flow

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            }

            if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        return left;
    }
}
