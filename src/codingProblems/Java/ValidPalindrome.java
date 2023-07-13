package codingProblems.Java;

import javax.xml.stream.events.Characters;
import java.util.Locale;

public class ValidPalindrome {

    public static void main(String args[]) {
        String s = "A man, a plan, a canal: Panama";

        System.out.println(isPalindrome(s));
    }

    /**
        Two Pointers
        TC: O(n)
     */
    private static boolean isPalindrome(String s) {


        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            char leftC = s.charAt(left);
            char rightC = s.charAt(right);

            if (!Character.isLetterOrDigit(leftC)) {

                left++;
            } else if (!Character.isLetterOrDigit(rightC)) {

                right--;
            } else if (Character.toLowerCase(leftC) != Character.toLowerCase(rightC)) {

                return false;
            } else {

                left++;
                right--;
            }
        }

        return true;
    }
}
