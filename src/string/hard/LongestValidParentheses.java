package string.hard;

/**
Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring.

Example 1:
Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".

Example 2:
Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".

Example 3:
Input: s = ""
Output: 0

Constraints:

0 <= s.length <= 3 * 104
s[i] is '(', or ')'.
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
    }

    public static int longestValidParentheses(String s) {
        int max = 0;
        int[] dp = new int[s.length() + 1];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
                dp[i + 1] = dp[i - 1] + 2;
            } else if (s.charAt(i) == ')' && s.charAt(i - 1) == ')') {
                if (i - dp[i] - 1 >= 0 && s.charAt(i - dp[i] - 1) == '(') {
                    dp[i + 1] = dp[i] + 2 + dp[i - dp[i] - 1];
                }
            }
            max = Math.max(max, dp[i + 1]);
        }
        return max;
    }
}
