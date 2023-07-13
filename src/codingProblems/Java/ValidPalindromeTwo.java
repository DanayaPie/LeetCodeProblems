package codingProblems.Java;

public class ValidPalindromeTwo {

    public static void main(String[] args) {

        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";

        System.out.println(validPalindrome(s));
    }

    /**
        Two Pointers
        TC: O(n)
     */
    public static boolean validPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {

                return (removedOneChar(s, left + 1, right) || removedOneChar(s, left, right - 1));
            }

            left++;
            right--;
        }

        return true;
    }

    private static boolean removedOneChar(String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {

                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
