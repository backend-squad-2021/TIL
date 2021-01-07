// https://www.acmicpc.net/problem/1052

import java.io.*;
import java.util.*;

class Main {
    private static final String lineSeparator = System.lineSeparator();

    private static class InputDto {
        final int n;
        final int k;

        InputDto(int n, int k) {
            this.n = n;
            this.k = k;
        }

        @Override
        public String toString() {
            return "n=" + n + ", k=" + k;
        }
    }

    private static int countBits(int decimal) {
        int count = 0;
        while (decimal > 0) {
            count += decimal & 1;
            decimal >>= 1;
        }
        return count;
    }

    private static String solve(InputDto input) {
        int n = input.n;
        int countOfBits = countBits(n);
        while (countOfBits > input.k) {
            countOfBits = countBits(++n);
        }
        int numOfBottles = n - input.n;
        return Integer.toString(numOfBottles);
    }

    private static void printFail(Object input, Object actual, Object expected) {
        System.out.println(lineSeparator);
        System.out.println("input: " + input);
        System.out.println("actual: " + actual);
        System.out.println("expected: " + expected);
    }

    private static void assertCountBits(int expected, int input) {
        int actual = countBits(input);
        if (expected == actual) {
            System.out.print("  !countBits success!  ");
            return;
        }
        printFail(input, actual, expected);
    }

    private static void assertSolve(String expected, InputDto input) {
        String actual = solve(input);
        if (expected.equals(actual)) {
            System.out.print("  !solve success!  ");
            return;
        }
        printFail(input, actual, expected);
    }

    private static void testCountBits() {
        assertCountBits(0, 0);
        assertCountBits(1, 1);
        assertCountBits(1, 2);
        assertCountBits(2, 3);
        assertCountBits(1, 4);
        assertCountBits(2, 5);
        assertCountBits(2, 6);
        assertCountBits(3, 7);
        assertCountBits(1, 8);
        assertCountBits(4, 15);
        assertCountBits(1, 16);
    }

    private static void testSolve() {
        assertSolve("1", new InputDto(3, 1));
    }

    private static void test() {
        testCountBits();
        testSolve();
    }

    private static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        InputDto input = new InputDto(n, k);

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
