package org.roman.easy;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 * <p>
 *
 *
 * Example 1:
 * <p>
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 * Example 2:
 * <p>
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 3:
 * <p>
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * <p>
 *
 * Constraints:
 * <p>
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 * <p>
 *
 * */

public class RomanToInteger3 {

    public static void main(String[] args) {
        RomanToInteger3 romanToInteger3 = new RomanToInteger3();
        System.out.println(romanToInteger3.romanToInt("III"));
        System.out.println(romanToInteger3.romanToInt("LVIII"));
        System.out.println(romanToInteger3.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {

        int I = 1;
        int V = 5;
        int X = 10;
        int L = 50;
        int C = 100;
        int D = 500;
        int M = 1000;

        String currentLetter = "";
        String previousLetter = "";

        int loop = 0;
        int result = 0;

        while (loop < s.length()) {
            if (loop != 0) {
                previousLetter = String.valueOf(s.charAt(loop - 1));
            }
            currentLetter = String.valueOf(s.charAt(loop));
            switch (currentLetter) {
                case "I" -> result = result + I;
                case "V" -> {
                    if (previousLetter.equals("I")) {
                        result = result - 2;
                    }
                    result = result + V;
                }
                case "X" -> {
                    if (previousLetter.equals("I")) {
                        result = result - 2;
                    }
                    result = result + X;
                }
                case "L" -> {
                    if (previousLetter.equals("X")) {
                        result = result - 20;
                    }
                    result = result + L;
                }
                case "C" -> {
                    if (previousLetter.equals("X")) {
                        result = result - 20;
                    }
                    result = result + C;
                }
                case "D" -> {
                    if (previousLetter.equals("C")) {
                        result = result - 200;
                    }
                    result = result + D;
                }
                case "M" -> {
                    if (previousLetter.equals("C")) {
                        result = result - 200;
                    }
                    result = result + M;
                }
            }

            loop++;
        }
        ;

        return result;

    }

}
