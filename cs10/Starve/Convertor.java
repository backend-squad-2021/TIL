public class Convertor {
    public boolean[] dec2bin(int decimal) {
        boolean[] answer = new boolean[8];
        int i = 0;
        while (decimal != 0) {
            answer[i] = (decimal % 2) == 1 ? true : false;
            decimal /= 2;

            i++;
        }
        return answer;
    }

    public int bin2dec(boolean[] bin) {
        int answer = 0;
        for (int i = 0; i < bin.length; i++) {
            int x = bin[i] == true ? 1 : 0;

            for (int j = 0; j < i; j++) {
                x *= 2;
            }
            answer += x;
        }

        return answer;
    }
}