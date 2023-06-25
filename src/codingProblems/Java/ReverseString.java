package codingProblems.Java;

public class ReverseString {

    public static void main(String[] args) {

        char[] s = {'m', 'a', 'n', 'g', 'o'};

        reverseString(s);

        System.out.println(s);
    }

    private static void reverseString(char[] s) {

        int left = 0;
        int right = s.length - 1;

        while (left < right) {

            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}
