//package com.company;

import static java.lang.System.*;
import java.util.Scanner;

import java.io.IOException;

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(in);

        int a,b,tc=0;
        tc = sc.nextInt();
        for(int t=0 ; t<tc ; t++) {

            a = sc.nextInt();
            b = sc.nextInt();
            int cur=1;

            if(a == 1) {
                out.println(1);
                continue;
            }
            else {

            }

            for(int i=0 ; i<b ; i++) {
                cur = cur*a;

                if(cur >= 10000000) {
                    cur = cur%100;
                }
            }
            cur = cur%10;
            if(cur == 0) {
                out.println("10");
            }
            else {
                out.println(cur);
            }

        }





        sc.close();

    }

}