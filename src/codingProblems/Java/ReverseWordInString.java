package codingProblems.Java;

public class ReverseWordInString {

    public static void main(String[] args) {

        String s = "sky is blue";

        System.out.println(reverseWordInString(s));
    }

    private static String reverseWordInString(String s) {

        StringBuilder res = new StringBuilder();

        int right = s.length() - 1;
        int left = right;

        // iterate through s in reverse
        for (int i = right; i >= 0; i --) {

            if (s.charAt(i) != ' ') {

                right = i;

                while ( i >= 0 && s.charAt(i) != ' ') {
                    i--;
                }
            }
        }
        return res.toString();
    }

//    private static String reverseWordInString(String s) {
//
//        String[] strArray = s.split(" ");
//        StringBuilder res = new StringBuilder();
//
//        for (int i = strArray.length - 1; i >= 0; i--) {
//
//            if (strArray[i] != "") {
//                res.append(strArray[i]);
//                res.append(" ");
//            }
//        }
//
//        return res.toString().trim();
//    }
}
