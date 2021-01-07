// https://www.acmicpc.net/problem/1009

import java.io.*;
import java.util.*;

class Main {
    private static final String lineSeparator = System.lineSeparator();

    private static class InputDto {
        final int a;
        final int b;

        InputDto(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "a=" + a + ", b=" + b;
        }
    }

    private static String solve(InputDto input) {
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

    private static void printFail(Object input, Object actual, Object expected) {
        System.out.println(lineSeparator);
        System.out.println("input: " + input);
        System.out.println("actual: " + actual);
        System.out.println("expected: " + expected);
    }

    private static void assertSolve(String expected, InputDto input) {
        String actual = solve(input);
        if (expected.equals(actual)) {
            System.out.print("  !solve Success!  ");
            return;
        }
        printFail(input, actual, expected);
    }

    private static void test() {
        assertSolve("1", new InputDto(1, 6));
        assertSolve("7", new InputDto(3, 7));
        assertSolve("6", new InputDto(6, 2));
        assertSolve("1", new InputDto(7, 100));
        assertSolve("9", new InputDto(9, 635));
        assertSolve("10", new InputDto(10, 100));
    }

    private static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            InputDto input = new InputDto(a, b);
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
