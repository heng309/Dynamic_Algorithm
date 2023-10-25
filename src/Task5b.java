import java.util.Scanner;

public class Task5b {
  public static String alg5(int m, int n, int h, int[][] plots) {

    int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
    int mx = 0;

    if (m < 2 || n < 2) {//1x1
      return 0 + " " + 0 + " " + 0 + " " + 0;
    }
    if (m < 3 || n < 3) {//2x2
      return 0 + " " + 0 + " " + 1 + " " + 1;
    }

    //find +
    int[][] dp = new int[m][n];
    int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    for (int i = 1; i < m - 1; i++) {
      for (int j = 1; j < n - 1; j++) {
        boolean allNotLessThanN = true;
        //				This for loop doesn't impact time complexity, since 4 iterations are a constant.
        for (int k = 0; k < dirs.length; k++) {
          int[] dir = dirs[k];
          int ii = i + dir[0]; //i-1 i+1 i+0 i
          int jj = j + dir[1]; //j+0 j+0 j+1 j-1
          if (plots[ii][jj] < h || plots[i][j] < h) {
            allNotLessThanN = false;
          }
        }
        if (allNotLessThanN) {
          dp[i][j] = 3;
        }
      }
    }
    //4x4
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (dp[i][j] == dp[i - 1][j]
            && dp[i][j] == dp[i][j - 1]
            && dp[i][j] == dp[i - 1][j - 1]
            && dp[i][j] != 0) {
          dp[i][j]++;
        }
        mx = Math.max(mx, dp[i][j]);
      }
    }
    //		System.out.println(Arrays.deepToString(dp));
    //		System.out.println(mx);
    if (mx == 0) {
      x1 = 0;
      y1 = 0;
      x2 = 1;
      y2 = 1;
    } else {
      outerloop:
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (dp[i][j] == mx) {
            x2 = i + 1;
            y2 = j + 1;
            x1 = i - mx + 2;
            y1 = j - mx + 2;
            break outerloop;
          }
        }
      }
    }
    return x1 + " " + y1 + " " + x2 + " " + y2;
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
    String a = alg5(m, n, h, plots);
    System.out.println(a);
  }
}
