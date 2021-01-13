// https://leetcode.com/problems/reverse-integer/submissions/

public class Solution {
    public int reverse(int x) {
        char[] arr = String.valueOf(x).toCharArray();
        boolean isNegative = arr[0] == '-';
        int index = arr.length - 1;

        while (arr[index] == '0' && index > 0) {
            index--;
        }

        int len = index + (isNegative ? 0 : 1);

        char[] answerArr = new char[len];
        for (int i = 0; i < len; i++) {
            answerArr[i] = arr[index - i];
        }

        int answer;
        try {
            answer = Integer.parseInt(String.valueOf(answerArr));
        } catch (Exception e) {
            return 0;
        }
        return isNegative ? -1 * answer : answer;
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

    private static void assertReverse(InputDto input, int expected) {
        int actual = new Solution().reverse(input.x);
        if (expected == actual) {
            return;
        }
        System.err.println(System.lineSeparator());
        System.err.println("input: " + input);
        System.err.println("actual: " + actual);
        System.err.println("expected: " + expected);
    }

    public static void main(String[] args) {
        assertReverse(new InputDto(123), 321);
        assertReverse(new InputDto(-123), -321);
        assertReverse(new InputDto(120), 21);
        assertReverse(new InputDto(0), 0);
        assertReverse(new InputDto(1534236469), 0);
    }
}
