package codingProblems.Java;

import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[] args) {
        String s = "XXX";

        System.out.println(romanToInt(s));
    }

    // HashMap - slower
    public static int romanToInt(String s) {

        int res = 0;

        HashMap<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        for (int i = 0; i < s.length(); i++) {
            int val1 = roman.get(s.charAt(i));

            if (i + 1 < s.length()) {
                int val2 = roman.get(s.charAt(i + 1));

                if (val1 >= val2) {
                    res = res + val1;
                } else {
                    res = res + val2 - val1;
                    i++;
                }
            } else {
                res = res + val1;
            }
        }
        return res;
    }

//    // switch case
//    public static int romanToInt(String s) {
//
//        int res = 0;
//        int val = 0;
//
//        // work backward
//        for (int i = s.length() - 1; i >= 0; i--) {
//            switch(s.charAt(i)) {
//                case 'I' : val = 1; break;
//                case 'V' : val = 5;  break;
//                case 'X' : val = 10;  break;
//                case 'L' : val = 50;  break;
//                case 'C' : val = 100;  break;
//                case 'D' : val = 500;  break;
//                case 'M' : val = 1000;  break;
//            }
//
//            // time 4 to avoid error with 3 repeating roman
//            if (4 * val < res) {
//                res -= val;
//            } else {
//                res += val;
//            }
//        }
//        return res;
//    }
}
