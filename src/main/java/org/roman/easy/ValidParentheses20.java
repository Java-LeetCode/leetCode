package org.roman.easy;

import java.util.HashMap;
import java.util.Map;

public class ValidParentheses20 {

    public static void main(String[] args) {

        ValidParentheses20 obj = new ValidParentheses20();
        System.out.println(obj.isValid("()"));

    }

    public boolean isValid(String s) {

        int loop = 0;
        int antiLoop = s.length() - 1;

        String currentBrackets;
        String lastBrackets = "";
        StringBuilder bracketsTogether = new StringBuilder();
        Map<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');

        boolean isClosed = false;

        if(s.isEmpty()) {
            return false;
        };

        while(loop < s.length() ){
            currentBrackets = String.valueOf(s.charAt(loop));
            if(antiLoop != 0) {
                lastBrackets = String.valueOf(s.charAt(antiLoop));
            }

            bracketsTogether.append(currentBrackets).append(lastBrackets);

            System.out.println(bracketsTogether);

            loop++;
            antiLoop--;
        }

        return isClosed;
    }

}
