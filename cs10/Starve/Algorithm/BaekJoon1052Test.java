public class BaekJoon1052Test {

  public static void main(String[] args) {
    resultEquals(1, 3, 1);
    resultEquals(1, 7, 1);
    resultEquals(7, 9, 1);

  }

  public static void resultEquals(int answer, int n, int k) {
    if (answer == BaekJoon1052.result(n, k)) {
      System.out.println("OK");
    } else {
      System.out.println("틀렸습니다!");
      System.out.println("n: " + n);
      System.out.println("k: " + k);
    }

  }
}
