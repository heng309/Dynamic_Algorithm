import java.util.Arrays;
import java.util.Scanner;

public class Task5a {

  public static String alg5(int m, int n, int h, int[][] plots) {

    int mx = 0;
    int[][] dp = new int[m][n];
    for (int i = 0; i < dp.length; i++) {
      Arrays.fill(dp[i], -1);
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (dp[i][j] == dp[i - 1][j]
            && dp[i][j] == dp[i][j - 1]
            && dp[i][j] == dp[i - 1][j - 1]
            && dp[i][j] != 0) {
          dp[i][j]++;
        }
        mx = Math.max(mx, helperMethod(i, j, h, plots, dp));
      }
    }
    return "0";
  }

  public static int helperMethod(int i, int j, int h, int[][] plots, int[][] dp) {
    int m = plots.length;
    int n = plots[0].length;
    if (i < 0 || j < 0 || i >= m || j >= n || plots[i][j] < h) {
      return 0;
    }
    if (dp[i][j] == -1) {
      return dp[i][j];
    }
    return dp[i][j] =
        Math.min(
            Math.min(helperMethod(i + 1, j, h, plots, dp), helperMethod(i, j + 1, h, plots, dp)),
            helperMethod(i + 1, j + 1, h, plots, dp));
  }

  public static void main(String[] args) {
    System.out.println("Please input m, n and h: ");
    Scanner scanner = new Scanner(System.in);
    String s1 = scanner.nextLine();
    int m = Integer.parseInt(s1.split(" ")[0]);
    int n = Integer.parseInt(s1.split(" ")[1]);
    int h = Integer.parseInt(s1.split(" ")[2]);
    int[][] plots = new int[m][n];

    System.out.println("Please input plots: ");
    Scanner scanner2 = new Scanner(System.in);
    for (int i = 0; i < m; i++) {
      String s2 = scanner2.nextLine();
      for (int j = 0; j < n; j++) {
        plots[i][j] = Integer.parseInt(s2.split(" ")[j]);
      }
    }
    String a = Task5b.alg5(m, n, h, plots);
    System.out.println(a);
  }
}
