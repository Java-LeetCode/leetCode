package org.roman.easy;

import java.util.HashMap;
import java.util.Map;

public class ValidParentheses20 {

    public static void main(String[] args) {

        ValidParentheses20 obj = new ValidParentheses20();
        System.out.println("case 1: " + obj.isValid("()") + " ✅");
        System.out.println("case 2: " + obj.isValid("()[]{}")+ " ✅");
        System.out.println("case 3: " + obj.isValid("(]") + " 🚫");
        System.out.println("case 4: " + obj.isValid("([])") + " ✅");
        System.out.println("case 5: " + obj.isValid("([)]")+ " 🚫");
        System.out.println("case 6: " + obj.isValid("((") + " 🚫");
        System.out.println("case 7: " + obj.isValid("(){}}{")+ " 🚫");
        System.out.println("case 8: " + obj.isValid("({{{{}}}))")+ " 🚫");

    }

    public boolean isValid(String s) {

        int loopTimes = s.length();

        int loop = 0;
        int antiLoop = s.length() - 1;
        int indexFor = 0;

        char currentBrackets;
        char nextBrackets = 0;
        char lastBrackets = 0;

        Map<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');

        boolean isClosed = false;
        boolean extremes = false;
        boolean continuation = false;

        if(s.isEmpty()) {
            return false;
        };

        if(s.charAt(s.length() - 1) == '{' || s.charAt(s.length() - 1) == '[' || s.charAt(s.length() - 1) == '(') {
            return false;
        }

        while(loop < loopTimes ){

            currentBrackets = s.charAt(loop);

            if(antiLoop != 0) {
                lastBrackets = s.charAt(antiLoop);
            }
            if(loop + 1 < s.length()) {
                nextBrackets = s.charAt(loop + 1);
            }

            for (Map.Entry<Character, Character> entry : map.entrySet()) {
                if(entry.getKey().equals(currentBrackets) && !entry.getValue().equals(lastBrackets)){
                    isClosed = false;
                    extremes = false;
                } else {
                    extremes = true;
                }
                if (entry.getKey().equals(currentBrackets) && entry.getValue().equals(nextBrackets)) {
                    isClosed = true;
                    continuation = true;
                }else {
                    continuation = false;
                }

                if(!continuation && !extremes) {
                    return false;
                }

                indexFor++;
                if(indexFor == 2) { break; }
            }
            loop++;
            antiLoop--;
        }

        return isClosed;
    }

}
