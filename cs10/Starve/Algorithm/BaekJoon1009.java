import java.io.*;
import java.util.StringTokenizer;

public class BaekJoon1009 {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(bufferedReader.readLine());

    for (int i = 0; i < t; i++) {
      StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

      int a = Integer.parseInt(stringTokenizer.nextToken());
      int b = Integer.parseInt(stringTokenizer.nextToken());

      System.out.println(result(a, b));
    }

    bufferedReader.close();
  }

  public static int result(int a, int b) {
    int answer = 1;
    for (int j = 0; j < b; j++) {
      answer = (answer * a) % 10;
      if (answer == 0) {
        answer = 10;
      }
    }

    return answer;
  }
}
