package codingProblems.Java;

public class HappyNumber {

    public static void main(String[] args) {

        int n = 19;

        System.out.println(isHappy(n));
    }

    /**
        Fast and Slow Pointers
        TC: O(n/2) = O(n)
     */
    public static boolean isHappy(int n) {

        int slow = n;
        int fast = nextN(n);

        // break when fast == 1 or when fast loop and catch up with slow
        while (fast != 1 && slow != fast) {

            slow = nextN(slow); // move 1 step at a time
            fast = nextN(nextN(fast)); // move 2 steps at a time
        }

        return fast == 1; // true if fast == 1, else false
    }

    private static int nextN(int n) {

        int squareSum = 0;

        while (n > 0) {

            int digit = n % 10;
            squareSum += Math.pow(digit, 2);
            n = n / 10;
        }

        return squareSum;
    }

    /**
     Hash Set
     TC: O(log n)
     SC: O(log n)
     n is the given number
     */
//    public static boolean isHappy(int n){
//
//        HashSet<Integer> seenSet = new HashSet<>();
//
//        while (n != 1) {
//
//            if (seenSet.contains(n)) {
//                return false;
//            }
//
//            seenSet.add(n);
//            n = nextN(n);
//        }
//
//        return true;
//    }
//
//    private static int nextN(int n) {
//
//        int squareSum = 0;
//
//        while (n > 0) {
//
//            int digit = n % 10;
//            squareSum += Math.pow(digit, 2);
//            n = n / 10;
//        }
//
//        return squareSum;
//    }
}
