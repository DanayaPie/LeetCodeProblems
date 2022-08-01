package codingProblems.Java;

public class LengthOfLastWord {

    // only counting the length of the last word
    public static void main(String[] args) {
        String s = "  today is a nice day   ";

        System.out.println(lengthOfLastWord(s));
    }

    private static int lengthOfLastWord(String s) {
        int length = 0;
        s = s.trim();

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } else {
                break;
            }
        }

        return length;
    }
}
