package codingProblems.Java;

public class PlusOne {

    /*-
    Logic:
        - decrementing the array, if last digit is 9, set it to 0
        - if digits[0] is 0, set it to 1 in a new array w .length + 1
            -> trailing digits is always 0
            -> output never = [0]
     */
    public static void main(String[] args) {
        int[] digits = {9, 9};

        digits = plusOne(digits);

        for (int i = 0; i < digits.length; i++) {
            System.out.println(digits[i]);
        }
    }

    private static int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                break;
            }
        }

        if (digits[0] == 0) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }

        return digits;
    }
}
