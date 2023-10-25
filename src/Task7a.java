import java.util.*;

public class Task7a {

  public static String alg7(int m, int n, int h, int k, int[][] p) {
    Map<String, Integer> memo = new HashMap<>();
    int max_area = 0;
    int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        for (int s = 1; s <= Math.min(m - i + 1, n - j + 1); s++) {
          String key = i + "," + j + "," + s;
          int req;
          if (memo.containsKey(key)) {
            req = memo.get(key);
          } else {
            req = recursion(p, i, j, s, m, n);
            memo.put(key, req);
          }
          if (req <= h && s * s <= k && s * s > max_area) {
            max_area = s * s;
            x1 = i + 1;
            y1 = j + 1;
            x2 = i + s;
            y2 = j + s;
          }
        }
      }
    }
    return x1 + " " + y1 + " " + x2 + " " + y2;
  }

  public static int recursion(int[][] p, int i, int j, int s, int m, int n) {
    if (i < 0 || j < 0 || i + s > m || j + s > n) {
      return -1;
    } else if (s == 1) {
      return p[i][j];
    } else {
      int s1 = s / 2;
      int s2 = s - s1;
      int req1 = recursion(p, i, j, s1, m, n);
      int req2 = recursion(p, i + s1, j, s2, m, n);
      int req3 = recursion(p, i, j + s1, s1, m, n);
      int req4 = recursion(p, i + s1, j + s1, s2, m, n);
      return Math.max(Math.max(req1, req2), Math.max(req3, req4));
    }
  }

  public static void main(String[] args) {

    System.out.println("Please input m, n, h and k: ");
    Scanner scanner = new Scanner(System.in);
    String s1 = scanner.nextLine();
    int m = Integer.parseInt(s1.split(" ")[0]);
    int n = Integer.parseInt(s1.split(" ")[1]);
    int h = Integer.parseInt(s1.split(" ")[2]);
    int k = Integer.parseInt(s1.split(" ")[3]);
    int[][] plots = new int[m][n];

    System.out.println("Please input plots: ");
    Scanner scanner2 = new Scanner(System.in);
    for (int i = 0; i < m; i++) {
      String s2 = scanner2.nextLine();
      for (int j = 0; j < n; j++) {
        plots[i][j] = Integer.parseInt(s2.split(" ")[j]);
      }
    }
    String a = alg7(m, n, h, k, plots);
    System.out.println(a);
  }
}
