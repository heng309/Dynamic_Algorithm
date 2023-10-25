import java.util.Scanner;

public class Task3 {
  public static String alg3(int m, int n, int h, int[][] plots) {

    int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
    int mx = 0;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (plots[i][j] < h) {
          plots[i][j] = 0;
        } else {
          if (i == 0 || j == 0) {
            plots[i][j] = 1;
          } else {
            plots[i][j] =
                Math.min(Math.min(plots[i - 1][j], plots[i][j - 1]), plots[i - 1][j - 1]) + 1;
          }
          mx = Math.max(mx, plots[i][j]);
        }
      }
    }
    //		System.out.println(Arrays.deepToString(plots));
    //		System.out.println(mx);
    if (mx == 0) return "No such square.";
    else {
      outerloop:
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (plots[i][j] == mx) {
            x2 = i;
            y2 = j;
            x1 = i - mx + 1;
            y1 = j - mx + 1;
            break outerloop;
          }
        }
      }
      return x1 + " " + y1 + " " + x2 + " " + y2;
    }
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
    String a = alg3(m, n, h, plots);
    System.out.println(a);
  }
}
