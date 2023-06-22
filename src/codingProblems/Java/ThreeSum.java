package codingProblems.Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {

        int[] arr = {-1, 0, 1, -2, 2};

        System.out.println(threeSum(arr));
    }

    /*
        2 pointers - must sort the array
        TC: O(n^2)
        SC: O(1) or O(n)
     */
    public static List<List<Integer>> threeSum(int[] arr) {

        List<List<Integer>> resList = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {

            if (i != 0 && arr[i] == arr[i - 1]) {
                continue;
            } else {

                int left = i + 1;
                int right = arr.length - 1;

                while (left < right) {
                    int threeSum = arr[i] + arr[left] + arr[right];

                    if (threeSum < 0) {

                        left++;
                    } else if (threeSum > 0) {

                        right--;
                    } else {

                        ArrayList<Integer> res = new ArrayList<>();
                        res.add(arr[i]);
                        res.add(arr[left]);
                        res.add(arr[right]);

                        resList.add(res);

                        left++;
                        while (arr[left] == arr[left - 1] && left < right) {
                            left++;
                        }
                    }
                }
            }
        }

        return resList;
    }
}
