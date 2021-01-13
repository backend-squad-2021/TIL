import java.util.ArrayList;

class Solution {
    public int reverse(int x) {
        
  ArrayList<String> a1 = new ArrayList<>();
        ArrayList<String> a2 = new ArrayList<>();

        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) return 0;

        String X = String.valueOf(x);

        for (int i = 0; i < X.length(); i++) {
            a1.add(X.substring(i, i + 1));
        }

        for (int i = 1; i < a1.size() + 1; i++) {
            if (a1.get(0).equals("-") && i == 1) {
                a2.add(a1.get(0));
            }

            a2.add(a1.get(a1.size() - i));

            if (a1.get(0).equals("-") && i == a1.size()) {
                a2.remove(a1.size());
            }
        }

        String answer = "";
        for (int i = 0; i < a2.size(); i++) {
            answer += a2.get(i);

        }
        int intAnswer = Integer.parseInt(answer);


        return intAnswer;
    }
    }
