import java.util.*;

// https://leetcode.com/problems/two-sum

/**
 * Sum 과 관련된 문제의 핵심 아이디어
 * 1. 정렬한다.
 * 2. HashMap 을 활용한다. (선택할 숫자가 1개만 남으면 hashmap 으로 연결한다.)
 * 관련문제: https://leetcode.com/problems/3sum
 */

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        Map<Integer, Integer> map = new HashMap();

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < len; i++) {
            int remainder = target - nums[i];
            Integer j = map.get(remainder);
            if (j != null && i != j) {
                answer[0] = i;
                answer[1] = j;
                break;
            }
        }

        return answer;
    }

    private static class InputDto {
        final int[] nums;
        final int target;

        InputDto(int[] nums, int target) {
            this.nums = nums;
            this.target = target;
        }

        @Override
        public String toString() {
            return "nums=" + Arrays.toString(nums) + ", target=" + target;
        }
    }

    private static void assertTwoSum(InputDto input, int[] expected) {
        int[] actual = new Solution().twoSum(input.nums, input.target);
        if (Arrays.equals(expected, actual)) {
            return;
        }
        System.err.println(System.lineSeparator());
        System.err.println("input: " + input);
        System.err.println("actual: " + Arrays.toString(actual));
        System.err.println("expected: " + Arrays.toString(expected));
    }

    public static void main(String[] args) {
        assertTwoSum(new InputDto(new int[]{2, 7, 11, 15}, 9),
                new int[]{0, 1});
        assertTwoSum(new InputDto(new int[]{3, 2, 4}, 6),
                new int[]{1, 2});
        assertTwoSum(new InputDto(new int[]{3, 3}, 6),
                new int[]{0, 1});
    }
}
