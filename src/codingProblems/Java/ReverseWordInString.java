package codingProblems.Java;

public class ReverseWordInString {

    public static void main(String[] args) {

        String s = "sky is blue";

        System.out.println(reverseWordInString(s));
    }

    /**
        Two Pointers
        TC: O(n) where n is the number of char
     */
    public static String reverseWordInString(String s) {

        StringBuilder res = new StringBuilder();

        int right = s.length() - 1;
        int left;

        // iterate through s in reverse
        for (int i = s.length() - 1; i >= 0; i--) {

            if (s.charAt(i) == ' ') { // if i is ' ' then append the word to the right of i

                left = i + 1;

                for (int j = left; j <= right; j++) {

                    res.append(s.charAt(j));
                }

                res.append(" ");
                right = i - 1;
            }
        }

        // append the first word
        for (int j = 0; j <= right; j++) {

            res.append(s.charAt(j));
        }

        return res.toString();
    }

    /**
        Two Pointers w Split String
        TC: O(n) where n is number of words
            - round up from O(n + n/2)
     */
//    private static String reverseWordInString(String s) {
//
//        String[] sArray = s.split(" "); // O(n)
//        StringBuilder sb = new StringBuilder();
//
//        int left = 0;
//        int right = sArray.length - 1;
//
//        while (left < right) {
//
//            String temp = sArray[left];
//            sArray[left] = sArray[right];
//            sArray[right] = temp;
//
//            sb.append(sArray[left]);
//            sb.append(" ");
//
//            left++;
//            right--;
//        }
//
//        while (left < sArray.length) {
//
//            sb.append(sArray[left]);
//            sb.append(" ");
//
//            left++;
//        }
//
//        return sb.toString();
//    }

    /**
        Split String
        TC: O(n) where n is number of words
            - round up from O(n + n/2)
     */
//    private static String reverseWordInString(String s) {
//
//        String[] sArray = s.split(" "); // O(n)
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = sArray.length - 1; i >= 0; i--) {
//
//            sb.append(sArray[i]);
//            sb.append(' ');
//        }
//
//        return sb.toString();
//    }
}
