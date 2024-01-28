package string.hard;

/**
 * You are given a string s. You can convert s to a palindrome by adding characters in front of it.
 *
 * Return the shortest palindrome you can find by performing this transformation.
 *
 * Example 1:
 * Input: s = "aacecaaa"
 * Output: "aaacecaaa"
 *
 * Example 2:
 * Input: s = "abcd"
 * Output: "dcbabcd"
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of lowercase English letters only.
 */
public class ShortestPalindrome {
    public static void main(String[] args) {
        System.out.println(shortestPalindrome("aacecaaa"));
    }

    public static String shortestPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        int end = j;
        char[] chars = s.toCharArray();
        while (i < j) {
            if (chars[i] == chars[j]) {
                i++;
                j--;
            } else {
                i = 0;
                end--;
                j = end;
            }
        }
        return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
    }
}
