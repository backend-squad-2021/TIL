package leetcode;

import java.util.Arrays;

class TwoSum {
    public static int[] twoSum ( int[] nums, int target){
    
        int[] answer = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= j) {
                    continue;
                }
                if (target == nums[i] + nums[j]) {
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }

            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4, 6}, 6)));
    
    }
}
