package codingProblems.Java;

public class PalindromeNumber {

    // without parsing to String

    public static void main(String[] args) {
        int x = 1221;

        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {

        int reverse = 0;
        boolean palindrome = false;

        if (x < 0 || (x % 10 == 0 && x != 0)) {
            palindrome = false;
        } else {
            while (x > reverse) {
                reverse = reverse * 10 + x % 10; // * 10 move the decimal backward - Ex: reverse 12 = 20 + 1
                x = x / 10; // move decimal forward
            }
            if (x == reverse || x == reverse / 10) { // reverse /10 disregard the middle digit
                palindrome = true;
            }
        }
        return palindrome;
    }

//    // toString solution - slow
//    public boolean isPalindrome(int x) {
//
//        boolean palindrome = false;
//        String input = Integer.toString(x);
//        StringBuffer reverse = new StringBuffer();
//
//        for (int i = input.length()-1; i >= 0; i--) {
//
//            reverse.append(input.charAt(i));
//        }
//        if (input.equals(reverse.toString())){
//            palindrome = true;
//        }
//
//        return palindrome;
//    }
}
