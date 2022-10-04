package codingProblems.Java;

public class SqrtX {

    /*-
    Logic:
        - Binary Search
     */
    public static void main(String[] args){
        int x = 2;

        System.out.println(mySqrt(x));
    }

    public static Integer mySqrt(int x) {

        if (x <= 1) {
            return x;
        }

        int res = 1;
        int min = 1;
        int max = x/2;

        while (min <= max) {
            int mid = min + (max - min)/2;

            if (mid <= x/mid) {
                res = mid;
                min = mid + 1;
            } else {
                max = mid -1;
            }
        }

        return res;
    }
}
