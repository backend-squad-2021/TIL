public class Adder {

    public boolean[] halfAdder(boolean bitA, boolean bitB) {
        boolean[] answer = {false, false}; // answer[0] : carry, answer[1] : sum

        answer[0] = bitA && bitB;
        answer[1] = bitA ^ bitB; // !(bitA && bitB) && (bitA || bitB);

        return answer;
    }

    public boolean[] fullAdder(boolean bitA, boolean bitB, boolean carry) {
        boolean[] answer = {false, false}; // answer[0] : carry, answer[1] : sum

        boolean[] halfAdder1 = halfAdder(bitA, bitB);
        boolean[] halfAdder2 = halfAdder(carry, halfAdder1[1]);
        answer[0] = halfAdder1[0] || halfAdder2[0];
        answer[1] = halfAdder2[1];

        return answer;
    }

    public boolean[] byteAdder(boolean[] byteA, boolean[] byteB) {
        boolean[] answer = new boolean[byteA.length + 1];
        boolean carry = false;

        for (int i = 0; i < byteA.length; i++) {
            boolean[] sum = fullAdder(byteA[i], byteB[i], carry);
            carry = sum[0];
            answer[i] = sum[1];
        }
        answer[answer.length - 1] = carry;  // add carry at the end of bits
        return answer;
    }
}