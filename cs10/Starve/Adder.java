public class Adder {
    public boolean[] halfAdder(boolean bitA, boolean bitB) {
        boolean carry = bitA & bitB;
        boolean sum = bitA ^ bitB;
        boolean[] answer = {carry,sum};
        return answer;
    }
    public boolean[] fullAdder(boolean bitA, boolean bitB, boolean carry) {
        boolean sum = (bitA ^ bitB)^carry;
        boolean carry2 = bitA & bitB || (bitA^bitB)&carry;
        boolean[] answer = {carry2,sum};
        return answer;
    }

    public boolean[] byteAdder(boolean[] byteA, boolean[] byteB) {
        boolean carry = false;
        boolean[] answer = new boolean[byteA.length+1];
        for(int i = 0; i<byteA.length; i++){
            boolean[] sum = fullAdder(byteA[i],byteB[i],carry);
            carry = sum[0];
            answer[i]=sum[1];
        }
        answer[answer.length-1]= carry;

        return answer;
    }

}
