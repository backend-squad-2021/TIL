// https://leetcode.com/problems/palindrome-number

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        boolean answer = true;
        String str = String.valueOf(x);
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            answer &= str.charAt(i) == str.charAt(len - i - 1);
        }
        return answer;
    }

    private static class InputDto {
        final int x;

        InputDto(int x) {
            this.x = x;
        }

        @Override
        public String toString() {
            return "x=" + x;
        }
    }

    private static void assertIsPalindrome(InputDto input, boolean expected) {
        boolean actual = new Solution().isPalindrome(input.x);
        if (expected == actual) {
            return;
        }
        System.err.println(System.lineSeparator());
        System.err.println("input: " + input);
        System.err.println("actual: " + actual);
        System.err.println("expected: " + expected);
    }

    public static void main(String[] args) {
        assertIsPalindrome(new InputDto(121), true);
        assertIsPalindrome(new InputDto(-121), false);
        assertIsPalindrome(new InputDto(10), false);
        assertIsPalindrome(new InputDto(-101), false);
        assertIsPalindrome(new InputDto(101), true);
    }
}
