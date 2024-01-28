package string.medium;

import java.util.HashSet;
import java.util.Set;

/**
 Given a string s, find the length of the longest substring without repeating characters.

 Example 1:
 Input: s = "abcabcbb"
 Output: 3
 Explanation: The answer is "abc", with the length of 3.

 Example 2:
 Input: s = "bbbbb"
 Output: 1
 Explanation: The answer is "b", with the length of 1.

 Example 3:
 Input: s = "pwwkew"
 Output: 3
 Explanation: The answer is "wke", with the length of 3.
 Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

 Constraints:
 0 <= s.length <= 5 * 104
 s consists of English letters, digits, symbols and spaces.
 */

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcdbb"));
        System.out.println(lengthOfLongestSubstring2("abcabcdbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;
        int end = 0;
        int[] map = new int[128];
        while (end < s.length()) {
            char c = s.charAt(end);
            map[c]++;
            while (map[c] > 1) {
                char c2 = s.charAt(start);
                map[c2]--;
                start++;
            }
            max = Math.max(max, end - start + 1);
            end++;
        }
        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {

        int max = 0;

        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                String sub = s.substring(i, j+1);
                if(isUnique(sub)){
                    max = Math.max(max, sub.length());
                }
            }
        }
        return max;
    }

    private static boolean isUnique(String sub) {
        Set<Character> set = new HashSet<>();
        for(char c : sub.toCharArray()){
            if(set.contains(c)){
                return false;
            }
            set.add(c);
        }
        return true;
    }
}
