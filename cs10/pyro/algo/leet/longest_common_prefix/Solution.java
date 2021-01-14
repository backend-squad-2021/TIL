// https://leetcode.com/problems/longest-common-prefix

import java.util.*;

/**
 * https://jason9319.tistory.com/141
 * Suffix Array
 */

/**
 * https://www.geeksforgeeks.org/longest-common-prefix-using-trie
 * Trie
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) {
            return "";
        }
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        Set<String> prefixSet = new HashSet<>();
        for (int i = 1; i <= strs[0].length(); i++) {
            prefixSet.add(strs[0].substring(0, i));
        }

        int prefixLength = strs[0].length();
        if (prefixLength < 1) {
            return "";
        }

        for (int i = 1; i < strs.length; i++) {
            String prefix = strs[i].substring(0, prefixLength);
            while (!prefixSet.contains(prefix)) {
                if (--prefixLength < 0) {
                    return "";
                }
                prefix = strs[i].substring(0, prefixLength);
            }
        }
        return strs[0].substring(0, prefixLength);
    }

    private static class InputDto {
        final String[] strs;

        InputDto(String[] strs) {
            this.strs = strs;
        }

        @Override
        public String toString() {
            return "strs=" + Arrays.toString(strs);
        }
    }

    private static void assertLongestCommonPrefix(InputDto input, String expected) {
        String actual = new Solution().longestCommonPrefix(input.strs);
        if (expected.equals(actual)) {
            return;
        }
        System.err.println(System.lineSeparator());
        System.err.println("input: " + input);
        System.err.println("actual: " + actual);
        System.err.println("expected: " + expected);
    }

    public static void main(String[] args) {
        assertLongestCommonPrefix(new InputDto(new String[]{"flower", "flow", "flight"}), "fl");
        assertLongestCommonPrefix(new InputDto(new String[]{"dog", "racecar", "car"}), "");
        assertLongestCommonPrefix(new InputDto(new String[]{"ab", "a"}), "a");
        assertLongestCommonPrefix(new InputDto(new String[]{"", "", ""}), "");
        assertLongestCommonPrefix(new InputDto(new String[]{}), "");
    }
}
