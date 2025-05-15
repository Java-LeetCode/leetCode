package org.roman.easy;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 *
 *
 * Example 1:
 * <p>
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * <p>
 *
 * Constraints:
 * <p>
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters if it is non-empty.
 * */

public class LongestCommonPrefix14 {

    public static void main(String[] args) {
        LongestCommonPrefix14 lcp = new LongestCommonPrefix14();
        System.out.println(lcp.longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
        System.out.println(lcp.longestCommonPrefix(new String[] { "flower","flower","flower","flower" }));
        System.out.println(lcp.longestCommonPrefix(new String[] { "dog", "racecar", "car" }));
        System.out.println(lcp.longestCommonPrefix(new String[] { "a" }));
        System.out.println(lcp.longestCommonPrefix(new String[] { "", "" }));
        System.out.println(lcp.longestCommonPrefix(new String[] { "cir","car" }));
        System.out.println(lcp.longestCommonPrefix(new String[] { "aa","aa" }));
        System.out.println(lcp.longestCommonPrefix(new String[] { "aa","a" }));
        System.out.println(lcp.longestCommonPrefix(new String[] { "abab","aba","" }));
        System.out.println(lcp.longestCommonPrefix(new String[] { "baab","bacb","b","cbc" }));

    }

    public String longestCommonPrefix(String[] strs) {

        String currentLetter = "";
        String currentLetterFirstWord;
        StringBuilder resultLetter = new StringBuilder();

        String firstWord = strs[0];

        int index = 1;
        int subIndex = 0;

        if(strs.length == 1){
            return strs[0];
        }

        for (int i = 1; i < strs.length; i++) {
            if(strs[i].isEmpty()){
                return "";
            }
            if(i != index){
                index++;
                firstWord = resultLetter.toString();
                resultLetter = new StringBuilder();
            }
            for (int j = 0; j < firstWord.length(); j++) {

                if(j < strs[index].length()){
                    subIndex = j;
                    currentLetter = String.valueOf(strs[index].charAt(j));
                }
                currentLetterFirstWord = String.valueOf(firstWord.charAt(j));
                if(currentLetterFirstWord.equals(currentLetter) && subIndex == j){
                    resultLetter.append(currentLetter);
                }else {
                    break;
                }
            }
        }
        return resultLetter.toString();
    }
}
