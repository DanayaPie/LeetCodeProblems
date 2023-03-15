package codingProblems.Java;

import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[] args) {
        String s = "CMXLIII";

        System.out.println(romanToInt(s));
    }

    /**
     * HashMap - O(n)
     **/
    /*
        instantiate an int variable as res and set it to zero
        instantiate hashMap as map with Character key and Integer value
        add all Roman to hashMap where symbol is key and number is value
        iterate through the input string using i as iterator
        instantiate an int variable and store the current index value as valL
        verify that the next index is not larger than input length -> prevent index out of bound
            if not,
                instantiate an int variable and store the next index value as valR
                compare whether valL is greater than or equal to valR
                    if yes, add valL to res
                    else set res to res plus difference of valR and valL
                        increment i iterator by 1 to skip to the next index
            else add valL to res
        return res
     */
    private static int romanToInt(String s) {

        int res = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (int i = 0; i < s.length(); i++) {
            int valL = map.get(s.charAt(i));


            if (i + 1 < s.length()) {
                int valR = map.get(s.charAt(i + 1));

                if (valL >= valR) {
                    res += valL;
                } else {
                    res += (valR - valL);
                    i++;
                }
            } else {
                res += valL;
            }
        }
        return res;
    }

    /**
     *  Switch statement - O(n)
     **/
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
