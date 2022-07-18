package codingProblems;

import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class DuplicateZeros {

    /*-
    Logic:
        1. Brute force (2 pointers) - shift to the right at each zero => O(n^2)
        2. Queue - add each arr element to queue while removing it into the arr, add two 0s if ele is 0 => O(n)
        3. count #0 then replace element => O(2n)
        4. clone the array, EXTRA space - O(n)
     */

    public static void main(String[] args) {
        int[] arr = {0, 1, 0};

        duplicateZeros(arr);

        System.out.println(Arrays.toString(arr));
    }

    // clone the array
    public static void duplicateZeros(int[] arr) {
        int[] tempArr = arr.clone();
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if (i < arr.length) {

                arr[i] = tempArr[j];
                if (tempArr[j] == 0 && i + 1 < arr.length) {
                    arr[i + 1] = 0;
                    i += 2;
                } else {
                    i++;
                }
            } else {
                break;
            }
        }
    }

//    // count #0 then replace
//    public static void duplicateZeros(int[] arr) {
//        int count = 0;
//
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == 0 ) {
//                count++;
//            }
//        }
//        for (int i = arr.length -1; i >= 0; i--) { //i start form the end
//            int currIndex = count + i;
//
//            // if current index != 0 and is not the last, assign it to element before
//            if (currIndex < arr.length) {
//                arr[currIndex] = arr[i];
//            }
//
//            // if current index -1 is 0 and is not the last, assign it to zero
//            if (arr[i] == 0) {
//                if (currIndex - 1 < arr.length) {
//                    arr[currIndex - 1] = arr[i];
//                }
//                count--;
//            }
//        }
//    }

//    // Queue
//    public static void duplicateZeros(int[] arr) {
//
//        Queue<Integer> tempQ = new LinkedList<>();
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == 0) {
//                tempQ.add(0);
//                tempQ.add(0);
//            } else {
//                tempQ.add(arr[i]);
//            }
//            arr[i] = tempQ.poll();
//        }
//    }

//    // Bruce force
//    public static void duplicateZeros(int[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == 0) {
//                for (int j = arr.length - -1; j > i; j++) { // j start at the end
//                    arr[j] = arr [j-1]; // replace j with the element before
//                }
//                i++;
//            }
//        }
//    }
}
