package codingProblems.Java;

public class WordSearch {

    public static void main(String[] args) {

        char[][] board = {{'A', 'B', 'C', 'E'}, {'B', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";

        System.out.println(exist(board, word));
    }

    /**
     * Backtracking - DFS
     * TC: O(m * n * 3^l) m * n are the dimension of the board, l is the length of character, 3^l is the branching factor of recursive calls
     * SC: O(l), space for recursion stack during backtracking process
     */
    public static boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (checkChar(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean checkChar(char[][] board, String word, int row, int col, int index) {

        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }

        char charFoundTemp = board[row][col];
        board[row][col] = '$'; // mark as found

        boolean found = checkChar(board, word, row + 1, col, index + 1) ||
                checkChar(board, word, row - 1, col, index + 1) ||
                checkChar(board, word, row, col + 1, index + 1) ||
                checkChar(board, word, row, col - 1, index + 1);

        board[row][col] = charFoundTemp;

        return found;
    }
}
