//package com.company;

import static java.lang.System.*;
import java.util.Scanner;

import java.io.IOException;

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);

        int nbot = 0;
        int k = 0;
        int ans = 0;

        nbot = sc.nextInt();
        k = sc.nextInt();

        if (nbot <= k) {
            out.println(0);
            //이미 조건을 만족하는 경우 물병을 추가구매하지 않음
            return;
        }

        for (ans=0; ;ans++) {
            int cnt = 0;
            int temp = nbot;

            while (temp!=0) {
                if ((temp % 2) != 0) {
                    cnt++;
                }
                // 물병을 합치는 과정, 4개>2개>1개 // 5개>3개>2개
                temp /= 2;
            }
            //cnt에 물병의 갯수가 주어짐.

            if (cnt <= k) {
                break;
                // 조건을 만족하면 그만!
            }
            nbot++;// 하나 더 사서 물병의 갯수합치면서 구해본다

        }
        
        out.println(ans);


    }


}