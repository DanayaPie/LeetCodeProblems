package codingProblems;

public class AddBinary {

    /*-
    Logic:
        - Convert string to int while adding
        - use StringBuilder
            - .append() then .reverse() to return correct order --> faster
            - .insert(offset, char) = insert at specific offset location --> slower
     */
    public static void main(String[] args) {
        String a = "100";
        String b = "1";

        System.out.println(addBinary(a, b));
    }

    // int carry w/ .append()
    public static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();

        while (i >= 0 || j >= 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i--) - '0'; // minus '0' is converting to integer
            }

            if (j >= 0) {
                sum += b.charAt(j--) - '0'; // minus '0' is converting to integer
            }

            // insert at the end
            res.append(sum % 2); // sum % 2 => get 2 possible answer, 1 or 0

            // carry will can only be 1 or 0
            carry = sum / 2; // if sum is 2, carry = 1; if sum is 1, carry = 0 (round down)
        }

        if (carry > 0) {
            res.append(1); // if carry is 1, insert 1 at the end
        }
        return res.reverse().toString();
    }

//    // int carry w/ .insert()
//    private static String addBinary(String a, String b) {
//
//        int i = a.length() - 1;
//        int j = b.length() - 1;
//        int carry = 0;
//        StringBuilder res = new StringBuilder();
//
//        while (i >= 0 || j >= 0) {
//            int sum = carry;
//
//            if (i >= 0) {
//                sum += a.charAt(i--) - '0'; // minus '0' is converting to integer
//            }
//            if (j >= 0) {
//                sum += b.charAt(j--) - '0'; // minus '0' is converting to integer
//            }
//            res.insert(0, sum % 2); // sum % 2 => get 2 possible answer, 1 or 0
//            carry = sum / 2; // if sum is 2, carry = 1; if sum is 1, carry = 0 (round down)
//        }
//
//        if (carry > 0) {
//            res.insert(0, 1); // if carry is 1, insert 1 at the end
//        }
//        return res.toString();
//    }
}
