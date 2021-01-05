public class Convertor {

    public boolean[] dec2bin(int decimal) {
        boolean[] answer = new boolean[8];
        int idx = 0;

        while (decimal > 0) {
            boolean isOdd = (decimal % 2) == 1;
            answer[idx++] = isOdd;
            decimal /= 2;
        }

        return answer;
    }

    public int bin2dec(boolean[] bin) {
        int answer = 0;

        for (int i = 0; i < bin.length; i++) {
            int num = bin[i] == true ? 1 : 0;

            for (int j = 0; j < i; j++) {
                num *= 2;
            }
            answer += num;
        }

        return answer;
    }
}
