public class Adder {
    public boolean[] halfAdder(boolean bitA, boolean bitB) {
        boolean carry = bitA & bitB;
        boolean sum = bitA ^ bitB;
        boolean[] answer = {carry, sum};
        return answer;
    }

    public boolean[] fullAdder(boolean bitA, boolean bitB, boolean carry) {
        boolean[] halfAdder1 = halfAdder(bitA, bitB);
        boolean[] halfAdder2 = halfAdder(carry, halfAdder1[1]);
        boolean fullAdderSum = halfAdder2[1];
        boolean fullAdderCarry = halfAdder1[0] | halfAdder2[0];
        boolean[] answer = {fullAdderCarry, fullAdderSum};
        return answer;
    }

    public boolean[] byteAdder(boolean[] byteA, boolean[] byteB) {
        boolean carry = false;
        boolean[] answer = new boolean[9];
        for (int i = 0; i < answer.length - 1; i++) {
            boolean[] sum = fullAdder(byteA[i], byteB[i], carry);
            carry = sum[0];
            answer[i] = sum[1];
        }
        answer[answer.length - 1] = carry;

        return answer;
    }

}

