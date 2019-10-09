package com.felix.leetcode.october;

/**
 * @author liujie3@yidian-inc.com
 * @version 1.0
 * @date: 2019/10/9 9:33 AM
 * @desc:
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 */

public class LongestPalindrome {

    /**
     * 1. 暴力搜索
     * 2. 动态规划
     */
    Map<String, String> map = new HashMap<String, String>();

    public String longestPalindrome(String s) {
        if (null == s || s.length() <= 1)
            return s;

        return getLongestPalindrome(s, 0, s.length() - 1);
    }

    private boolean isPalindrome(String s, int i, int j) {
        if (map.containsKey(i + "-" + j))
            return true;
        if (i >= j || (isPalindrome(s, i + 1, j - 1) && s.charAt(i) == s.charAt(j))) {
            map.put(i + "-" + j, s.substring(i, j + 1));
            return true;
        }
        return false;
    }

    private String getLongestPalindrome(String s, int i, int j) {

        if (map.containsKey(i + "-" + j))
            return map.get(i + "-" + j);
        if (isPalindrome(s, i, j))
            return s.substring(i, j + 1);
        else {
            String a = getLongestPalindrome(s, i + 1, j);
            String b = getLongestPalindrome(s, i, j - 1);
            if (a.length() >= b.length())
                return a;
            else
                return b;
        }
    }
}
