package codingProblems.Java;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {

        int[] nums = {5, 6, 1, 4};
        int target = 5;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    /**
     *  HashMap - O(n)
     */
    /*
     *
     *  instantiated a hashMap as map
     *  iterate through the input array using iterator i
     *  find if the map contain the differences between the target value and the value of current index
     *  if map contain the difference value return the current index and the differences value's index that is stored in map
     *  if map does not contain the difference value, store the current value as key in map and store the index of the current index as value in map
     *  continue iteration
     */
//    public static int[] twoSum(int[] nums, int target) {
//
//        HashMap map = new HashMap<Integer,Integer>();
//
//        for(int i = 0;i < nums.length;i++){
//            if(map.containsKey(target - nums[i])){
//                return new int[] {i,(int) map.get(target - nums[i])};
//            } else {
//                map.put(nums[i], i);
//            }
//        }
//        return null;
//    }

    /**
     *  Nested for loop - O(2n)
     */
    /*
     *  iterate through the input array as i iterator
     *      nested for loop using j as iterator (j start at i +1)
     *
     *          is target - value at j is value at i?
     *              if yes, return i, j
     *              if no, j continue to iterate
     *      if j not find any value, iterate i
     *          j = i + 1
     *
     **/
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == target - nums[j]) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }
}
