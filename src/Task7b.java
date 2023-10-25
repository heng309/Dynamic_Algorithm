import java.util.Scanner;

public class Task7b {
  public static String alg7(int m, int n, int h, int k, int[][] plots) {

    int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
    int mx = 0;
    int[][] dp = new int[m][n];
    int[][][] history = new int[m][n][Math.min(m, n) + 1];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (plots[i][j] < h) {
          dp[i][j] = 1;
        }
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int dir = 1;
        int twoDim = 0;
        if (dp[i][j] == 1) {
          history[i][j][1] = 1;
        }
        while (i - dir >= 0 && j - dir >= 0) {
          twoDim += dp[i - dir][j] + dp[i][j - dir];
          if (history[i - 1][j - 1][dir] + twoDim + dp[i][j] <= k) {
            history[i][j][dir + 1] = history[i - 1][j - 1][dir] + twoDim + dp[i][j];
            dir++;
            if (dir > mx) {
              mx = dir;
              x2 = i;
              y2 = j;
              x1 = i - dir + 1;
              y1 = j - dir + 1;
            }
          } else break;
        }
      }
    }
    return x1 + " " + y1 + " " + x2 + " " + y2;
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
