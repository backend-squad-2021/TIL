import java.io.*;

enum Colors {
  black(0, 1),
  brown(1, 10),
  red(2, 100),
  orange(3, 1000),
  yellow(4, 10000),
  green(5, 100000),
  blue(6, 1000000),
  violet(7, 10000000),
  grey(8, 100000000),
  white(9, 1000000000);

  int value;
  int multiply;

  Colors(int value, int multiply) {
    this.value = value;
    this.multiply = multiply;
  }

  public int getValue() {
    return value;
  }

  public int getMultiply() {
    return multiply;
  }
}

public class BaekJoon1076 {


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String a = br.readLine();
    String b = br.readLine();
    String c = br.readLine();

    System.out.println(result(a, b, c));

    br.close();
  }

  public static long result(String input1, String input2, String input3) {
    Colors colors = Colors.valueOf(Colors.class, input1);

    long answer = colors.getValue() * 10;
    answer += Colors.valueOf(Colors.class, input2).getValue();
    answer *= Colors.valueOf(Colors.class, input3).getMultiply();

    return answer;
  }
}
