package codingProblems.Java;

public class KthSmallestEleInSortedMatrix {

    public static void main(String[] args) {

        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k = 8;

        System.out.println(kthSmallest(matrix, k));
    }


    /**
     * Binary Search
     * TC: O(n log(maxVal - minVal)), O(n) from numEleSmallOrEqlMid() scanning through row and col
     * SC: O(1)
     */
    public static int kthSmallest(int[][] matrix, int k) {
        int left = matrix[0][0];
        int right = matrix[matrix.length - 1][matrix.length - 1];

        while (left < right) {

            int mid = left + (right - left) / 2;
            int count = numEleSmallOrEqlMid(matrix, mid); // count num of ele that smaller or equal to mid

            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }

        return left;
    }

    private static int numEleSmallOrEqlMid(int[][] matrix, int mid) {

        int count = 0;
        int row = 0;
        int col = matrix.length - 1;


        while (row < matrix.length && col >= 0) {

            if (matrix[row][col] <= mid) {
                count += col + 1; // count the num of column from
                row++;
            } else {
                col--;
            }
        }

        return count;
    }

    /**
     * Heap - Priority Queue
     * TC: O(k log(min(k, n, m), m is the number of column
     * - constructing the initial minHeap: O(min(k, n))
     * - iterate k times: O(k log(min(k, n))), constant time poll(), k log(min(k, n)) offer operation on minHeap Kth times
     * SC: O(n)
     */
//    public static int kthSmallest(int[][] matrix, int k) {
//
//        int rows = matrix.length;
//        int cols = matrix[0].length;
//
//        // creating minHeap with smaller ele at the top
//        /*
//            a[0]: the value of the element in the matrix
//            a[1]: the row index of the element in the matrix
//            a[2]: the column index of the element in the matrix
//                - will compare values in third column of the 2D matrix
//                - will compare values at index 2 in 1D array
//
//            Result:
//                - negative (a[2] < b[2]): a has higher priority (smaller)
//                - positive (a[2] > b[2]): b has higher priority (smaller)
//                - zero (a[2] = b[2]): priority determined by their natural order
//         */
//        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
//
//        // create int[] with 3 elements from each row at 0 column index
//        for (int i = 0; i < rows; i++) {
//            // i is row, 0 is column, matrix[i][0] is the value in the matrix at row i and column 0
//            minHeap.offer(new int[]{i, 0, matrix[i][0]});
//        }
//
//        // iterate through PQ Kth time to find Kth smallest ele
//        for (int i = 0; i < k - 1; i++) {
//            int[] curr = minHeap.poll();
//            int row = curr[0];
//            int col = curr[1];
//
//            // if column is still within the matrix, push next ele in next col but same row into minHeap
//            if (col < cols - 1) {
//                minHeap.offer(new int[]{row, col + 1, matrix[row][col + 1]});
//            }
//        }
//
//        return minHeap.peek()[2];
//    }

    /**
     * Brute Force
     * TC: O(n^2 log (n^2))
     * SC: O(n^2)
     */
//    public static int kthSmallest(int[][] matrix, int k) {
//
//        int[] nums = new int[matrix.length * matrix.length];
//        int numIndex = 0;
//
//        for (int i = 0; i < matrix.length; i++) {
//
//            for (int j = 0; j < matrix[i].length; j++) {
//                nums[numIndex++] = matrix[i][j];
//            }
//        }
//
//        Arrays.sort(nums);
//        return nums[k - 1];
//    }
}
