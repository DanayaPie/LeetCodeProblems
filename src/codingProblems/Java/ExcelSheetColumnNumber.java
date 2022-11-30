package codingProblems.Java;

public class ExcelSheetColumnNumber {

    /*-
        Logic:
            - Using ASCII -> 'A' = 65
            - 26 characters in alphabet
            - calculation: (i * 26) + characterValue
     */
    public static void main(String[] args) {
        String columnTitle = "Pie";

        System.out.println(titleToNumber(columnTitle));
    }

    private static Integer titleToNumber(String columnTitle) {

        int res = 0;

        for (int i = 0; i < columnTitle.length(); i++) {

            res *= 26;
            res += (columnTitle.charAt(i) - 'A' + 1); // '+ 1' to set 'A' to 1

        }
        return res;
    }
}
