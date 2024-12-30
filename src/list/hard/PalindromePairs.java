package list.hard;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

/**
 * You are given a 0-indexed array of unique strings words.
 *
 * A palindrome pair is a pair of integers (i, j) such that:
 *
 * 0 <= i, j < words.length,
 * i != j, and
 * words[i] + words[j] (the concatenation of the two strings) is a
 * palindrome
 * .
 * Return an array of all the palindrome pairs of words.
 *
 * You must write an algorithm with O(sum of words[i].length) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]]
 * Explanation: The palindromes are ["abcddcba","dcbaabcd","slls","llssssll"]
 * Example 2:
 *
 * Input: words = ["bat","tab","cat"]
 * Output: [[0,1],[1,0]]
 * Explanation: The palindromes are ["battab","tabbat"]
 * Example 3:
 *
 * Input: words = ["a",""]
 * Output: [[0,1],[1,0]]
 * Explanation: The palindromes are ["a","a"]
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 5000
 * 0 <= words[i].length <= 300
 * words[i] consists of lowercase English letters.
 */
public class PalindromePairs {
    public static void main(String[] args) {
        System.out.println(palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}));
    }

    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String left = words[i].substring(0, j);
                String right = words[i].substring(j);
                if (isPalindrome(left)) {
                    String rightReverse = new StringBuilder(right).reverse().toString();
                    if (map.containsKey(rightReverse) && map.get(rightReverse) != i) {
                        result.add(Arrays.asList(map.get(rightReverse), i));
                    }
                }
                if (isPalindrome(right) && right.length() != 0) {
                    String leftReverse = new StringBuilder(left).reverse().toString();
                    if (map.containsKey(leftReverse) && map.get(leftReverse) != i) {
                        result.add(Arrays.asList(i, map.get(leftReverse)));
                    }
                }
            }
        }
        return result;
    }

    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
