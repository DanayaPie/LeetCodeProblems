package codingProblems.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {

        int[] arr = {-1, 0, 1, 2, -1, -4};

        System.out.println(threeSum(arr));
    }

    /**
        Two Pointers - must sort the array
        TC: O(n^2)
        SC: O(1) or O(n)
     */
    public static List<List<Integer>> threeSum(int[] arr) {

        List<List<Integer>> resList = new ArrayList<>();
        Arrays.sort(arr); // O(n log n)

        int right = arr.length - 1;

        for (int i = 0; i < arr.length; i++) {

            if (i != 0 && arr[i] == arr[i - 1]) {
                continue;
            } else {

                int left = i + 1;

                while (left < right) {

                    int threeSum = arr[i] + arr[left] + arr[right];

                    if (threeSum < 0) {

                        left++;
                    } else if (threeSum > 0) {

                        right--;
                    } else {

                        ArrayList<Integer> threeSumList = new ArrayList<>();
                        threeSumList.add(arr[i]);
                        threeSumList.add(arr[left]);
                        threeSumList.add(arr[right]);

                        resList.add(threeSumList);
                        left++;
                        right--;
                    }

                }
            }
        }

        return resList;
    }
}
