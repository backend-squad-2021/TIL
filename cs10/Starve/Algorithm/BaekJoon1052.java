import java.io.*;
import java.util.StringTokenizer;

public class BaekJoon1052 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    System.out.println(result(n, k));

    br.close();
  }

  public static int count(int n) {
    int cnt = 0;

    while (n > 0) {
      cnt += n & 1;
      n >>= 1;
    }
    return cnt;
  }

  public static int result(int n, int k) {
    int x = 0;

    while (count(n + x) > k) {
      x++;
    }

    return x;
  }
}
