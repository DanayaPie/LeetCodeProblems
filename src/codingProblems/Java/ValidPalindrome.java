package codingProblems.Java;

public class ValidPalindrome {

    /*-
        Logics:
            - 2 pointers method
            - use isLetterOrDigit()
            - use toLowerCase()
     */
    public static void main(String args[]) {
        String s = "A man, a plan, a canal: Panama";

        System.out.println(isPalindrome(s));
    }

    private static boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char lc = s.charAt(left);
            char rc = s.charAt(right);

            if (!Character.isLetterOrDigit(lc)) {
                left++;
            } else if (!Character.isLetterOrDigit(rc)) {
                right--;
            } else {
                if (Character.toLowerCase(lc) != Character.toLowerCase(rc)) {
                    return false;
                }

                left++;
                right--;
            }
        }

        return true;
    }
}
