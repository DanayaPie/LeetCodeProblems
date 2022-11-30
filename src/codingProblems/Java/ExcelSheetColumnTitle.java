package codingProblems.Java;

public class ExcelSheetColumnTitle {

    /*-
        Logic:
            - Using ASCII -> 'A' = 65
            - 26 characters in alphabet
     */
    public static void main(String[] args) {
        int columnNumber = 701;

        System.out.println(convertToTitle(columnNumber));
    }

    private static String convertToTitle(int columnNumber) {

        StringBuilder res = new StringBuilder();

        while (columnNumber > 0) {

            columnNumber--; // - 1 to set 'A' to 1
            res.append((char) ((columnNumber - 1) % 26 + 'A'));
            columnNumber /= 26;
        }
        res.reverse(); // reverse because the character was found from right to left
        return res.toString();
    }
}
