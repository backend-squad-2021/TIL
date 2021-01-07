public class BaekJoon1076Test {

  public static void main(String[] args) {
    resultEquals(4700, "yellow", "violet", "red");

  }

  public static void resultEquals(long answer, String a, String b, String c) {
    if (answer == BaekJoon1076.result(a, b, c)) {
      System.out.println("OK");
    } else {
      System.out.println("틀렸습니다!");
      System.out.println("a: " + a);
      System.out.println("b: " + b);
      System.out.println("c: " + c);
    }

  }
}
