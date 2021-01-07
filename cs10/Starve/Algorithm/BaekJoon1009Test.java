public class BaekJoon1009Test {

  public static void main(String[] args) {
    resultEquals(1, 1, 6);
    resultEquals(7, 3, 7);
    resultEquals(6, 6, 2);
    resultEquals(1, 7, 100);
    resultEquals(9, 9, 635);
    resultEquals(10, 10, 100);

  }

  public static void resultEquals(int answer, int a, int b) {
    if (answer == BaekJoon1009.result(a, b)) {
      System.out.println("OK");
    } else {
      System.out.println("틀렸습니다!");
      System.out.println("a: " + a);
      System.out.println("b: " + b);
    }

  }
}
