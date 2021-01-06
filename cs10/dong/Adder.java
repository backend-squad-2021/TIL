package com.company;

import static java.lang.System.*;

public class Adder {
    public static void main(String[] args) {
        Adder add = new Adder();


        out.println("mission 1, half ===========");
        boolean[] h_tc1_ins = {true,true};
        boolean[] h_tc1_ret = {true,false};
        add.half_add_tester(h_tc1_ins,h_tc1_ret);

        boolean[] h_tc2_ins = {true,false};
        boolean[] h_tc2_ret = {false,true};
        add.half_add_tester(h_tc2_ins,h_tc2_ret);



        //전가산기 부분
        out.println("mission 1, full ===========");
        boolean[] f1_tc_ins = {false,false,false}; //000
        boolean[] f1_tc_ret = {false,false}; //00
        add.full_add_tester(f1_tc_ins,f1_tc_ret);

        boolean[] f2_tc_ins = {false,false,true}; //001
        boolean[] f2_tc_ret = {false,true}; //01
        add.full_add_tester(f2_tc_ins,f2_tc_ret);

        boolean[] f3_tc_ins = {false,true,false}; //010
        boolean[] f3_tc_ret = {false,true}; //01
        add.full_add_tester(f3_tc_ins,f3_tc_ret);

        boolean[] f4_tc_ins = {false,true,true}; //011
        boolean[] f4_tc_ret = {true,false}; //10
        add.full_add_tester(f4_tc_ins,f4_tc_ret);

        boolean[] f5_tc_ins = {true,false,false}; //100
        boolean[] f5_tc_ret = {false,true}; //01
        add.full_add_tester(f5_tc_ins,f5_tc_ret);

        boolean[] f6_tc_ins = {true,false,true}; //101
        boolean[] f6_tc_ret = {true,false}; //10
        add.full_add_tester(f6_tc_ins,f6_tc_ret);

        boolean[] f7_tc_ins = {true,true,false}; //110
        boolean[] f7_tc_ret = {true,false}; //10
        add.full_add_tester(f7_tc_ins,f7_tc_ret);


        boolean[] f8_tc_ins = {true,true,true}; //111
        boolean[] f8_tc_ret = {true,true};//캐리1,합1
        add.full_add_tester(f8_tc_ins,f8_tc_ret);


        //*
        out.println("mission 2 : byteadder ===========");
        boolean[] Byte_ins1A =       { true, true, false, true, true, false, true, false };
        boolean[] Byte_ins1B =       { true, false, true, true, false, false, true, true };
        boolean[] Byte_ret1 = { false, false, false, true, false, true, false, false, true };
        add.byte_add_tester(Byte_ins1A,Byte_ins1B,Byte_ret1);



        boolean[] Byte_ins2A =       { true, true, false, false, true, false, true, false};
        boolean[] Byte_ins2B =       { true, true, false, true, true, false, false, true};
        boolean[] Byte_ret2 = { false, true, true, true, false, true, true, true, false };
        add.byte_add_tester(Byte_ins2A, Byte_ins2B, Byte_ret2);

        //*/


    }



    /////////////////////////////////////////////////////////
    //mission 1
    /////////////////////////////////////////////////////////

    public static boolean[] halfadder(boolean bitA, boolean bitB) {
        boolean[] answer = new boolean[2];

        answer[1] = bitA ^ bitB ; // sum
        answer[0] = bitA && bitB; // carry

        return answer;
    }


    public static boolean[] fulladder(boolean bitA, boolean bitB, boolean carry) {
        boolean[] answer = new boolean[2];
        /* boolean ts = bitA ^ bitB; // temp sum
        boolean tc = bitA && bitB; // temp carry

        answer[1] = ts ^ carry ; // sum
        //answer[1] = (bitA && carry) || (bitA && bitB) || (carry && bitB); // carry
        // 연산자 하나 구현하는데 게이트로직 하나씩 더 필요함 -> 동일한 기능/성능에 더 적은 연산자(=로직)를 사용하는게 반도체 설계
        answer[0] = (tc || carry) ; // carry 비트중 둘중 하나가 1이고,
        //false,false,true
        */

        answer[1] = bitA ^ bitB;
        answer[1] = bitA ^ bitB ^ carry;
        answer[0] = (bitA && carry) || (bitA && bitB) || (carry && bitB); // carry
        return answer;
    }

    public void half_add_tester(boolean[] ins,boolean[] ret) {
        boolean[] temp = halfadder(ins[0],ins[1]);
        if ( (temp[0] == ret[0]) && (temp[1] == ret[1]) ) {
            out.println("OK!");
        }
        else {
            out.print("no : "+temp[0]+" "+temp[1] + "\n");
        }
    }

    public void full_add_tester(boolean[] ins,boolean[] ret) {
        boolean[] temp= fulladder(ins[0],ins[1],ins[2]);
        if ( (temp[0] == ret[0]) && (temp[1] == ret[1]) ) {
            out.println("OK!");
        }
        else {
            out.print("no : " + temp[0] + " " + temp[1] + "\n");
        }
    }


    /////////////////////////////////////////////////////////
    //mission 2
    /////////////////////////////////////////////////////////

    public boolean[] byteadder(boolean[] byteA, boolean[] byteB) {
        boolean[] answer = new boolean[9];
        boolean[] cary = new boolean[9];
        boolean[] temp = new boolean[2];

        cary[0] = false;

        for(int i=0 ; i<8 ; i++) {
            temp = fulladder(byteA[i],byteB[i],cary[i]);

            cary[i+1] = temp[0]; // carry

            answer[i] = temp[1]; //sum=1, carry=0;
        }
        //answer[8] = carrier[8];

        return answer;
    }





    public void byte_add_tester(boolean[] inA,boolean[] inB,boolean[] ret) {
        boolean[] temp= byteadder(inA,inB);

        for(int i=0; i <8 ; i++) {
            if (temp[i] != ret[i]) {
                //ok pass
                out.print("no : wrong at" + i+ ", value : " + temp[i] + "\n");


                out.print("ret : ");
                for(int j=0 ; j<8 ; j++) {
                    out.print(ret[j] + ",");
                }
                out.print("\n");


                out.print("temp : ");
                for(int j=0 ; j<8 ; j++) {
                    out.print(temp[j] + ",");
                }
                out.print("\n");


                return;// 테스트 탈락!
            }
        }
        out.println("OK!");
    }

}
