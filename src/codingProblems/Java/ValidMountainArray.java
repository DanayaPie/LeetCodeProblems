package codingProblems.Java;

public class ValidMountainArray {

    /*-
        Description:
            - arr.length >= 3
            - 0 < i < arr.length - 1:
                arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
                arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

        Logic:
            - check if start with increasing
            - cannot be plateau
            - once decreasing start, must continue decreasing
     */

    public static void main(String[] args) {

        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(validMountainArray(arr));
    }

    private static boolean validMountainArray(int[] arr) {

        if (arr.length < 3) {
            return false;
        }

        int i = 0;
        while (i < arr.length - 1 && arr[i] < arr[i + 1]) {
            i++;
        }

        /*-
            if i = size of array, there is no peak/decreasing
            if i = 0, there is no increase
         */
        if (i == arr.length - 1 || i == 0) {
            return false;
        }

        for (int j = i; j < arr.length - 1; j++) {
            if (arr[j] <= arr[j + 1]) {
                return false;
            }
        }

        return true;
    }


//    private static boolean validMountainArray(int[] arr) {
//
//        if (arr.length < 3) {
//            return false;
//        }
//
//        boolean increasing = arr[0] < arr[1];
//        if (!increasing) {
//            return false;
//        }
//
//        for (int i = 0; i < arr.length - 1; i++) {
//            if (arr[i] == arr[i + 1]) {
//                return false;
//            }
//            if (increasing) {
//                if (arr[i] > arr[i + 1]) {
//                    increasing = false;
//                }
//            } else {
//                if (arr[i] > arr[i + 1]) {
//                    return false;
//                }
//            }
//        }
//
//        return !increasing;
//    }
}
