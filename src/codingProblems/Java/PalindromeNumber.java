package codingProblems.Java;

public class PalindromeNumber {

    public static void main(String[] args) {
        int x = 121;

        System.out.println(isPalindrome(x));
    }

    /**
     * Modulus - O(n)
     */
    /*
        instantiate an int reverse variable and set it to zero
        check whether the input greater than zero using if statement
            if input is less than zero, return false
        check whether the input end with zero by using modulus of 10, input must not be zero
            if the input have a remainder of 0, return false
        perform the reverse steps until the input is smaller than the reverse using while statement
            reverse the input value and store it in the reverse variable by perform modulus of 10 and add reverse * 10 to increase digit or to add zero at the end
                (reverse value is getting larger)
            store input value as input divide 10 to remove the value already perform reverse (input value is getting smaller)
        check whether the input match the reverse using if statement
            if input match, return true
        check whether the input match reverse divide by 10 when it is a single digit
            if match, return true
     */
    private static boolean isPalindrome(int x) {

        int reverse = 0;

        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        } else {
            while (x > reverse) {

                reverse = x % 10 + reverse * 10;
                x = x / 10;
                System.out.println("x: " + x);
                System.out.println("reverse: " + reverse);
            }
            if (x == reverse || x == reverse / 10) {
                return true;
            }
        }
        return false;
    }

    /**
     * For loop - O(2n)
     * Convert to string
     */
    /*
        store input as input string using toString
        instantiate a string builder as reverse
        iterate through the input string in reverse using i as iterator
        store each value at i to the string builder using append()
        check if the value in the string input match the string in string builder
            if match return true
            else return false
     */
//    private static boolean isPalindrome(int x) {
//
//        String input = Integer.toString(x);
//        StringBuilder reverse = new StringBuilder();
//
//        for (int i = input.length() - 1; i >= 0; i --) {
//            reverse.append(input.charAt(i));
//        }
//        if (input.equals(reverse.toString())) {
//            return true;
//        }
//        return false;
//    }
}

