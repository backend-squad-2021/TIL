//package com.company;

import static java.lang.System.*;

import java.util.Arrays;
import java.util.Scanner;

import java.io.IOException;

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;

public class Main{

    //static char[]arra = new char[20000];
    static char[]arra;

    public static void main(String[] args) {
        Scanner sc = new Scanner(in);


        //0) 문자열 두개 입력받고
        String s1,s2,ans;
        s1 = sc.next();
        s2 = sc.next();

        //1) 문자열 뒤집어서 편하게 포문 돌리기 위해서
        s1 = reverse(s1);
        s2 = reverse(s2);
        //너무 당연해서 인식하지 못하고 있지만, 인간은
        // 숫자는 오른쪽에서 왼쪽으로,
        // 문자는 왼쪽에서 오른쪽으로
        //인지하기 때문에.. 숫자를 문자열로 처리하는 과정에서는 뒤집는 과정이 필요
        int maxi = max(s1.length(),s2.length());
        int mini = min(s1.length(),s2.length());

        if(s1.length() > s2.length()) {
            ans = new String(s1);
        }
        else {
            ans = new String (s2);
        }
        arra = new char[maxi+1];



        //2) 캐리를 생각하면서 한자리씩 계산해서 정답 문자열에 저장
        boolean is_carry = false;
        for(int i=0 ; i<mini ; i++) {
            int i1 = str2int(s1.substring(i,i+1));
            int i2 = str2int(s2.substring(i,i+1));
            int tmp = i1+i2;

            if(is_carry) {
                tmp++;
            }else {}

            if(tmp >= 10) {
                tmp = tmp-10;
                is_carry = true;
            }
            else {
                is_carry = false;
            }

            arra[i] = int2char(tmp);

        }

        //3) 문자열 길이 다른경우의 예외처리
        //99999 99 인 경우, 짧은거는 자리가 없어도 연산을 해줘야함
        for(int i=mini ; i<maxi ; i++) {

            char t= ans.charAt(i);
            //arra[i]
            int a = char2int(t);

            if(is_carry) {
                a++;
                is_carry = false;
            }else {}

            if(a>=10) {
                a = a-10;
                is_carry = true;
            }
            else {
                is_carry = false;
            }



            arra[i] = int2char(a);

        }



        //4) 맨 마지막 자리(가장 큰 숫자 위치에서) 캐리가 발생한경우
        //999 + 999 = 1998인데, 998이 발생하는 예외 처리
        if(is_carry) {
            arra[maxi] = '1';
        }



        //5) 뒤집어서 원래대로 만들고 정답 출력
        //ans = arra.toString();
        ans = String.copyValueOf(arra);
        ans = reverse(ans);
        ans = ans.trim();
        out.print(ans);
    }

    public static String reverse(String s) {
        return ((new StringBuffer(s)).reverse().toString());
    }

    public static int max(int a,int b) {
        if(a>b) {
            return a;
        }
        else {
            return b;
        }
    }

    public static int min(int a,int b) {
        if(a<b) {
            return a;
        }
        else {
            return b;
        }
    }


    public static int str2int(String s) {
        final String[] s2i = {"0", "1", "2", "3", "4","5", "6", "7", "8", "9"};
        for (int i = 0; i <= 9; i++) {
            if (s.equals(s2i[i])) {
                return i;
            }
        }
        return -1;
    }


    public static int char2int(char c) {
        return Character.getNumericValue(c);
    }

    public static char int2char(int i) {
        final char[] c2i = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        return c2i[i];
    }
}