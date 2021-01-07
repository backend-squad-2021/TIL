// https://www.acmicpc.net/problem/1000

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
        return Integer.toString(input.a + input.b);
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
        assertSolve("3", new InputDto(1, 2));
        assertSolve("12", new InputDto(5, 7));
    }

    private static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        InputDto input = new InputDto(a, b);

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
