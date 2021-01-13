package leetcode;

class TwoSum {
    public static int[] twoSum ( int[] nums, int target){
       
        int[] answer = new int[2];

        int count = nums.length;
        for (int i = 0; i < nums.length; i++) {
            count--;
            for (int j = 0; j < count; j++) {
                if (i <= j) {
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
        System.out.println(twoSum(new int[](3, 2, 4, 6), 6);
        /**
         * 문제1
         * new로 바로 인트배열만들었는데빨간줄
         * 문제2
         * 저렇게안하고 변수에 배열담아서 출력했는데 메모리 주소가 나옴
         */
    }
}

