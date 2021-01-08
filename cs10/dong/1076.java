//package com.company;

import static java.lang.System.*;
import java.util.Scanner;

import java.io.IOException;

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;

public class Main {
    static final String[] cmap = {
            "black","brown","red","orange","yellow",
            "green","blue","violet","grey","white"
    };

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(in);
        long ans=0;

        //first line
        String s = sc.next();
        ans = (s2val(s));


        //second line
        s = sc.next();
        ans = ans * 10;
        ans += s2val(s);

        //third line
        s = sc.next();
        ans = ans * s2gop(s);


        out.println(ans);
    }

    static long s2val(String s) {
        for(int i=0 ; i<10 ; i++) {
            if(s.equals(cmap[i])) {
                return (long)i;
            }
        }
        return (long)-1;
    }

    static long s2gop(String s) {
        int ret = 1;
        for(int i=0 ; i<10 ; i++) {
            if(s.equals(cmap[i])) {
                return ret;
            }
            else {
                ret = ret*10;
            }
        }
        return (long)(-1);
    }

}