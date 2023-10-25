import java.util.Scanner;

public class Task2 {
  public static String alg2(int m, int n, int h, int[][] plots) {

    int current = 0;
    int[][] globalmax = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (plots[i][j] >= h) {
          // first row
          int level = 0;
          for (int col_1 = j; col_1 < n; col_1++) {
            if (plots[i][col_1] >= h) {
              level += 1;
            } else break;
          }
          // rest of row
          if (i + 1 == m) { // the last row
            for (int col_1 = j; col_1 < n; col_1++) {
              if (plots[i][col_1] >= h) {
                level = 1;
              }
            }
          } else {
            for (int row = i + 1; row < m; row++) {
              if (row - i < level) {
                current = 0;
                for (int col = j; col < n; col++) {
                  if (plots[row][col] >= h && col - j < level) {
                    current += 1;
                  } else break;
                }
                if (current <= row - i) {
                  level = Math.min(row - i, level);
                  break;
                }
                level = Math.min(level, current);
              }
            }
          }
          globalmax[i][j] = level;
        } else {
          globalmax[i][j] = 0;
        }
      }
    }

    int x1 = 0, y1 = 0, x2 = 0, y2 = 0, max = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (globalmax[i][j] >= max) {
          max = globalmax[i][j];
          x1 = i;
          y1 = j;
        }
      }
    }
    x2 = max + x1 - 1;
    y2 = max + y1 - 1;
    if (max == 0) {
      return "No such square.";
    } else return x1 + " " + y1 + " " + x2 + " " + y2;
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
    String a = alg2(m, n, h, plots);
    System.out.println(a);
  }
}
