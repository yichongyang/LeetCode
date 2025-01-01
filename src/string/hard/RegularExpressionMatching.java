package string.hard;

/**
 Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

 '.' Matches any single character.​​​​
 '*' Matches zero or more of the preceding element.
 The matching should cover the entire input string (not partial).

 Example 1:
 Input: s = "aa", p = "a"
 Output: false
 Explanation: "a" does not match the entire string "aa".

 Example 2:
 Input: s = "aa", p = "a*"
 Output: true
 Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".

 Example 3:
 Input: s = "ab", p = ".*"
 Output: true
 Explanation: ".*" means "zero or more (*) of any character (.)".

 Constraints:
 1 <= s.length <= 20
 1 <= p.length <= 20
 s contains only lowercase English letters.
 p contains only lowercase English letters, '.', and '*'.
 It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
 */
public class RegularExpressionMatching {

    public static void main(String[] args) {
        RegularExpressionMatching solution = new RegularExpressionMatching();

        System.out.println(solution.isMatch("aa", "a*"));  // Output: true
        System.out.println(solution.isMatch("mississippi", "mis*is*p*."));  // Output: false
        System.out.println(solution.isMatch("ab", ".*"));  // Output: true

        System.out.println(solution.isMatch2("aa", "a*"));  // Output: true
        System.out.println(solution.isMatch2("mississippi", "mis*is*p*."));  // Output: false
        System.out.println(solution.isMatch2("ab", ".*"));  // Output: true
    }

    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        boolean firstMatch = !s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');

        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    public boolean isMatch2(String s, String p) {
        int m = s.length();
        int n = p.length();

        // dp[i][j] means whether s[0..i-1] matches p[0..j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Empty string matches empty pattern
        dp[0][0] = true;

        // Handle patterns with '*'
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char currentS = s.charAt(i - 1);
                char currentP = p.charAt(j - 1);

                if (currentP == currentS || currentP == '.') {
                    // Characters match, or '.' matches any character
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (currentP == '*') {
                    // '*' can either:
                    // 1. Match zero occurrences of the previous character
                    // 2. Match one or more occurrences if the previous character matches
                    dp[i][j] = dp[i][j - 2] // Zero occurrences
                            || (dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
                }
            }
        }
        return dp[m][n];
    }
}
