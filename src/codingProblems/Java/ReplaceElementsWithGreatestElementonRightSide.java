package codingProblems.Java;

public class ReplaceElementsWithGreatestElementonRightSide {

    /*-
        Logic:
            - transversal loop
            - set max to last value and set last index to -1
     */
    public static void main(String[] args) {

        int[] arr = {17, 18, 5, 4, 6, 1};

        arr = replaceElements(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    private static int[] replaceElements(int[] arr) {

        int max = arr[arr.length - 1];
        arr[arr.length - 1] = -1;

        for (int i = arr.length - 2; i >= 0; i--) {

            int currVal = arr[i];
            arr[i] = max;
            max = Math.max(max, currVal);
        }

        return arr;
    }
}
