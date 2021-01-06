// https://www.acmicpc.net/problem/1009

import java.io.*;
import java.util.*;

class Main {
    private static final String lineSeparator = System.lineSeparator();

    private static class Dto {
        final int a;
        final int b;

        Dto(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "a=" + a + ", b=" + b;
        }
    }

    private static String solve(Dto input) {
        int solution = 1;
        for (int i = 0; i < input.b; i++) {
            solution *= input.a;
            solution %= 10;
        }
        if (solution == 0) {
            solution = 10;
        }
        return Integer.toString(solution);
    }

    private static void assertOutputEquals(String expected, Dto input) {
        String output = solve(input);
        System.out.println(lineSeparator);
        if (expected.equals(output)) {
            System.out.println("!Success!");
            return;
        }
        System.out.println("input: " + input);
        System.out.println("actual: " + output);
        System.out.println("expected: " + expected);
    }

    private static void test() {
        assertOutputEquals("1", new Dto(1, 6));
        assertOutputEquals("7", new Dto(3, 7));
        assertOutputEquals("6", new Dto(6, 2));
        assertOutputEquals("1", new Dto(7, 100));
        assertOutputEquals("9", new Dto(9, 635));
        assertOutputEquals("10", new Dto(10, 100));
    }

    private static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Dto input = new Dto(a, b);
            String output = solve(input);
            bw.write(output + lineSeparator);
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        // test();
        main();
    }
}
