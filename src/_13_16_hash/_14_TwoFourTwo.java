package _13_16_hash;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/valid-anagram/
 */
public class _14_TwoFourTwo {
    /**
     * 比较每个单词中字母出现的次数
     * 也可以用hashmap实现（统计两个字符串出现的次数）
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] alpha = new int[26];
        for(int i=0;i<s.length();i++)
            alpha[s.charAt(i)-'a']++;
        for (int i = 0; i < t.length(); i++)
            alpha[t.charAt(i) - 'a']--;
        for (int i : alpha)
            if (i != 0)
                return false;
        return true;
    }
    /**
     * 排序后比较 时间复杂度更大
     * @param s
     * @param t
     * @return
             */
    public boolean isAnagram1(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chart);
        for (int i = 0; i < s.length(); i++){
            if(chars[i] != chart[i])
                return false;
        }
        return true;
    }
}
