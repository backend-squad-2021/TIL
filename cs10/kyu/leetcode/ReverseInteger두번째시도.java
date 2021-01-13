package leetcode;

import java.util.ArrayList;

public class ReverseInteger {
    public static int reverse(int x) {

        boolean neg = ( x < 0 ); // x가 0보다 작으면 트루
        long y = x; // int -> long 형변환 안해도됨
        if(neg) // neg가 음수인게 트루이면
            y = -y; // 양수로 바꾼다
        String temp1 = String.valueOf(y); //split을 위해 String으로 바꿔준다
        String[] temp2 = temp1.split(""); // 배열에 숫자 다 담는다.
        //@@@@@@@질문@@@@@@@@@@@:
        // temp2는 크기가 정해져 있지 않은데 어떻게 이렇게 넣는거지? 원리가뭐지?

        String temp3 = "";
        for (int i =1 ; i < temp2.length+1; i++) {
            temp3 += temp2[temp2.length-i]; // 배열에 있던거 다 더해준다
        }

        long X = Long.parseLong(temp3); // - 부호 붙이려고 그리고 정수범위넘을때 조건문주기위해
        if(neg)
            X = -X; // x가 0보다 작으면 트루인 경우에 다시 - 붙여줌

        if (X <= Integer.MIN_VALUE || X > Integer.MAX_VALUE)
            return 0; //정수범위넘을때 0리턴


        int answer = (int)X;
        return answer;

    }

    public static void main(String[] args) {
        ReverseInteger.reverse(-328945);
    }
}
