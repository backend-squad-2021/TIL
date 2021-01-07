// https://www.acmicpc.net/problem/1000

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
        return Integer.toString(input.a + input.b);
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
        assertOutputEquals("3", new Dto(1, 2));
        assertOutputEquals("12", new Dto(5, 7));
    }

    private static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        Dto input = new Dto(a, b);

        String output = solve(input);
        bw.write(output);

        br.close();
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        // test();
        main();
    }
}
