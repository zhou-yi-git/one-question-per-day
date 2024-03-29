package solution_0003.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ZhouYi
 * 2021/5/6 10:03 下午
 */
public class Solution {

    public int lengthOfLongestSubstringUseList(String s) {
        List<Character> subStr = new ArrayList<>();
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            final int index = subStr.indexOf(s.charAt(i));
            if (index > -1) {
                if (size < subStr.size()) {
                    size = subStr.size();
                }
                subStr = subStr.subList(index + 1, subStr.size());
            }
            subStr.add(s.charAt(i));
        }
        if (size < subStr.size()) {
            size = subStr.size();
        }
        return size;
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> subStr = new HashSet<>();
        int n = s.length(), kn = -1, size = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                subStr.remove(s.charAt(i - 1));
            }
            while (kn + 1 < n && !subStr.contains(s.charAt(kn + 1))) {
                subStr.add(s.charAt(kn + 1));
                kn++;
            }
            size = Math.max(size, kn - i + 1);
        }
        return size;
    }

    /**
     * 执行用时：8ms
     * 内存消耗：41.8MB
     */
    public int solution1(String s) {
        int max = 0;
        StringBuilder sw = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            max = Math.max(max, sw.length());
            String tmpS = s.substring(i, i + 1);
            int index = sw.indexOf(tmpS);
            if (index >= 0) {
                sw = new StringBuilder(sw.substring(index + 1));
            }
            sw.append(tmpS);
        }
        max = Math.max(max, sw.length());
        return max;
    }

    public static void main(String[] args) {
        cases("abcabcbb", 3);
        cases("bbbbb", 1);
        cases("pwwkew", 3);
        cases("", 0);
        cases(" ", 1);
        cases("dvdf", 3);
    }

    public static void cases(String s, int result) {
        //final int res = new Solution().lengthOfLongestSubstring(s);
        final int res = new Solution().solution1(s);
        System.out.println("ans:" + res);
        if (res == result) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        System.out.println("======================================");
    }

}
