package com.company;

import org.w3c.dom.ls.LSOutput;

import static  java.lang.System.*;


public class Convertor {
    public static void main(String[] args) {

        Convertor con = new Convertor();

        boolean[] b2d_tc1b = {false,true,false,true};
        int tc1d = 10;

        boolean[] b2d_tc2b = {true,false,true,true,false,true,false,true};//10110101
        int tc2d = 173;

        boolean[] b2d_tc3b = {false,true,true,true};
        int tc3d = 14;

        boolean[] b2d_tc4b = {true,true,true,true,false,true,false,true};
        int tc4d = 175;

        con.b2dtest(b2d_tc1b,tc1d);
        con.b2dtest(b2d_tc2b,tc2d);
        con.b2dtest(b2d_tc3b,tc3d);
        con.b2dtest(b2d_tc4b,tc4d);

        con.d2btest(tc1d,b2d_tc1b);
        con.d2btest(tc2d,b2d_tc2b);
        con.d2btest(tc3d,b2d_tc3b);
        con.d2btest(tc4d,b2d_tc4b);
    }




    //[미션1] 진법 변환기 : dec to Binary
    public boolean[] dec2bin(int decimal) {
        boolean[] buffer = new boolean[9];
        boolean[] answer = {};
        int actual=1;

        for(int i=0 ; i<99999999 ; i++) {
            buffer[i] = zo2bool(decimal%2);
            decimal /=2;
            if(decimal == 0 ){
                actual = i;
                break;
            }
        }

        answer = new boolean[actual];
        for(int i=0 ; i<actual ; i++) {
            answer[i] = buffer[i];
        }

        return answer;
    }

    boolean zo2bool (int in) {
        if (in==0) {
            return (false);
        }
        else {
            return (true);
        }
    }


    void d2btest(int ins,boolean[] ret) {
        boolean[] temp = dec2bin(ins);
        for(int i=0 ; i<temp.length ; i++) {
            if(temp[i] != ret[i]) {
                out.println("No........");
                return;
            }
        }
        out.println("OK!");
    }








    //[미션2] 진법 변환기 : Binary to dec
    void b2dtest(boolean[] ins, int ret) {
        if(ret == bin2dec(ins) ) {
            out.println("OK!");
        }
        else {
            out.print("No : ret=" + ret+ " : ");
            for(int i=0 ; i<ins.length ; i++) {
                out.print(ins[i]+", ");
            }
            out.print("\n");
        }

    }
    int bool2zo(boolean in) {
        return in ? 1:0;
    }

    int bin2dec(boolean[] arr) {
        int ret = 0;
        int len = arr.length;
        int significant = 1;

        for(int i=0 ; i<len ; i++) {
            ret = ret+ (bool2zo(arr[i])*significant);
            significant *= 2;
            //significant <<= 1; //more faster but, blocked by conditions
        }

        return ret;
    }






}
