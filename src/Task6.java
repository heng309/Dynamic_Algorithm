import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Task6 {
  public static String alg6(int m, int n, int h, int k, int[][] plots) {

    int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
    HashMap<Integer, int[]> res = new HashMap<>();
    //		  Search for all squares with maximum k plots less than h.
    for (int j = 0; j < n; j++) {
      for (int i = 0; i < m; i++) {
        x1 = i;
        y1 = j;
        x2 = i;
        y2 = j;
        if (plots[i][j] < h) {
          res.put(0, new int[] {x1, y1, x2, y2});
        }
        int distance = Math.min(m - i, n - j);
        for (int dis = 1; dis < distance; dis++) {
          if (issmallk(x1, y1, x1 + dis, y1 + dis, h, k, plots) == true) {
            int[] temp = new int[] {x1, y1, x1 + dis, y1 + dis};
            res.put(dis, temp);
          }
        }
      }
    }
    //		  If all squares have more than k plots that are less than h, then no solution will be
    // available.
    if (res.isEmpty()) {
      return "No such square.";
    }
    //		  Find the largest square.
    int max_dis = Collections.max(res.keySet());
    int[] max_res = res.get(max_dis);
    x1 = max_res[0];
    y1 = max_res[1];
    x2 = max_res[2];
    y2 = max_res[3];
    return x1 + " " + y1 + " " + x2 + " " + y2;
  }

  //	Determine whether the squares have maximum k plots less than h.
  public static boolean issmallk(int x1, int y1, int x2, int y2, int h, int k, int[][] plots) {

    boolean ans = true;
    int count = 0;
    for (int j = y1; j <= y2; j++) {
      for (int i = x1; i <= x2; i++) {
        if (plots[i][j] < h) {
          count++;
        }
      }
    }
    if (count > k) {
      ans = false;
    }
    return ans;
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
    String a = alg6(m, n, h, k, plots);
    System.out.println(a);
  }
}
