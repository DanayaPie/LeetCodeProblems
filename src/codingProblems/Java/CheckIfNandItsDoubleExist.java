package codingProblems.Java;

import java.util.HashSet;

public class CheckIfNandItsDoubleExist {

    /*-
        Description:
            - i != j
            - arr[1] == 2 * arr[j]
        Ways:
            1. hashSet
                - check if hasSet contain n * 2 or n % 2 == 0
                - slower if input size is small
            2. compare 2 values
                - do not store values
                - 2 for loops
                - faster if input size is small
     */

    public static void main(String[] args) {
//        int[] arr = {7, 1, 14, 11};
        int[] arr = {3, 1, 7, 11, 3};

        System.out.println(checkIfExist(arr));
    }

    // 1. hashSet
//    private static boolean checkIfExist(int[] arr) {
//
//        HashSet<Integer> existTable = new HashSet();
//
//        for (int i = 0; i < arr.length; i++) {
//
//            if (existTable.contains(arr[i] * 2) || (arr[i] % 2 == 0 && existTable.contains(arr[i] / 2))) {
//                return true;
//            } else {
//                existTable.add(arr[i]);
//            }
//        }
//        return false;
//    }

    // 2. compare 2 values
    private static boolean checkIfExist(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (isExist(arr, arr[i], i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isExist(int[] arr, int value, int j) {

        for (int i = 0; i < arr.length; i++){
            if (i != j && (arr[i] * 2 == value || value * 2 == arr[i])) {
                return true;
            }
        }
        return false;
    }


}
