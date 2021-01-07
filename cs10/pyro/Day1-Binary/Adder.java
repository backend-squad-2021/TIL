class Adder {
    boolean[] halfadder(boolean bitA, boolean bitB) {
        boolean carry = bitA & bitB;
        boolean sum = bitA ^ bitB;
        boolean[] answer = {carry, sum};
        return answer;
    }

    boolean[] fulladder(boolean bitA, boolean bitB, boolean carry) {
        boolean[] halfadder1 = halfadder(bitA, bitB);
        boolean[] halfadder2 = halfadder(carry, halfadder1[1]);
        boolean answer_carry = halfadder1[0] | halfadder2[0];
        boolean answer_sum = halfadder2[1];
        boolean[] answer = {answer_carry, answer_sum};
        return answer;
    }

    boolean[] byteadder(boolean[] byteA, boolean[] byteB) {
        int len = 8;
        boolean[] answer = new boolean[9];
        boolean carry = false;
        for (int i = 0; i < len; i++) {
            boolean[] fulladder = fulladder(byteA[i], byteB[i], carry);
            answer[i] = fulladder[1];
            carry = fulladder[0];
        }
        answer[len] = carry;
        return answer;
    }
}
