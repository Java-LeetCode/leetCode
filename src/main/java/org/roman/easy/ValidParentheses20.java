package org.roman.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * <p>
 *
 * Example 1:
 * <p>
 * Input: s = "()"
 * <p>
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: s = "()[]{}"
 * <p>
 * Output: true
 * <p>
 * Example 3:
 * <p>
 * Input: s = "(]"
 * <p>
 * Output: false
 * <p>
 * Example 4:
 * <p>
 * Input: s = "([])"
 * <p>
 * Output: true
 * <p>
 *
 *
 * Constraints:
 * <p>
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 * */

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
        System.out.println("case 8: " + obj.isValid(")(){}")+ " 🚫");
        System.out.println("case 9: " + obj.isValid("({{{{}}}))")+ " 🚫");
        System.out.println("case 10: " + obj.isValid("()))")+ " 🚫");

    }

    public boolean isValid(String s) {

        int loop = 0;

        if (s.isEmpty()) {
            return false;
        }

        if (s.charAt(s.length() - 1) == '{' || s.charAt(s.length() - 1) == '[' || s.charAt(s.length() - 1) == '(') {
            return false;
        }

        if (s.charAt(0) == '}' || s.charAt(0) == ']' || s.charAt(0) == ')') {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();

        while(loop < s.length() ){
            char current = s.charAt(loop);

            if (map.containsValue(current)) {
                stack.push(current);
            }
            else if (map.containsKey(current)) {
                if (stack.isEmpty() || stack.pop() != map.get(current)) {
                    return false;
                }
            } else {
                return false;
            }
            loop++;
        }
        return stack.isEmpty();
    }

}
