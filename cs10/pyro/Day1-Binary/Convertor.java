class Convertor {
    boolean[] dec2bin(int decimal) {
        int len = 0;
        int exponent = 1;
        while (exponent < decimal) {
            len++;
            exponent += exponent;
        }
        boolean[] answer = new boolean[len];
        for (int i = len - 1; i >= 0 && decimal > 0; i--) {
            exponent /= 2;
            answer[i] = exponent <= decimal;
            decimal -= answer[i] ? exponent : 0;
        }
        return answer;
    }

    int bin2dec(boolean[] bin) {
        int answer = 0;
        int exponent = 1;
        for (int i = 0; i < bin.length; i++) {
            answer += bin[i] ? exponent : 0;
            exponent += exponent;
        }
        return answer;
    }
}
