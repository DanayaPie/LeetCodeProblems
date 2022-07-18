package codingProblems;

public class RemoveElement {

    // return length of new array after elements are remove

    public void main(String[] args) {
        int[] nums = {2, 2, 2};
        int val = 2;

        System.out.println(removeElement(nums, val));
    }

    public int removeElement(int[] nums, int val) {
        int element = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[element] = nums[i];
                element++;
            }
        }
        return element;
    }
}
