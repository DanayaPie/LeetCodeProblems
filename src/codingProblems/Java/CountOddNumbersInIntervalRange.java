package codingProblems.Java;

public class CountOddNumbersInIntervalRange {
    public static void main(String[] args) {
        int low = 0;
        int high = 10;

        System.out.println(countOdds(low, high));
    }

    public static int countOdds(int low, int high) {

        int count = 0;

        if (low % 2 == 1 || high % 2 == 1) { // if low or high are odd
            count++;
        }

        count += (high - low) / 2;

        return count;
    }
}
