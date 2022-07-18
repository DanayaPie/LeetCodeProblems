package codingProblems;

public class ImplementStrStr {

    public static void main(String[] args) {

        String haystack = "ahaa";
        String needle = "aa";
        System.out.println(strStr(haystack, needle));
    }

//    // indexOf method - super fast!!! --> using Java language implementation
//    public static int strStr(String haystack, String needle) {
//        int i = haystack.indexOf(needle);
//        return i;
//    }


     // double for loops
     public static int strStr(String haystack, String needle) {

         // i cannot be longer than the different between haystack and needle length -> prevent needle index out of bounce
         for (int i = 0; i <= haystack.length() - needle.length(); i++) {

             // j must be less thand needle length
             // haystack element at i+j must match needle element at j
             for (int j = 0; j < needle.length() && haystack.charAt(i+j) == needle.charAt(j); j++) {

                 // if j is the last needle, return i as haystack index (loop until the end match)
                 if (j == needle.length() -1) {
                     return i;
                 }
             }
         }
         return -1;
     }


//     // use .contains() method - slower cuz it will check all the char in haystack
//     public static int strStr(String haystack, String needle) {
//         int n=needle.length();
//         int res=-1;
//         if (n == 0) {
//             return 0;
//         }
//         System.out.println(haystack.contains(needle));

//         if (haystack.contains(needle)) {
//             res=haystack.indexOf(needle);
//         }
//         return res;
//     }
}
