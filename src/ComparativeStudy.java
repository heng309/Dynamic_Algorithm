import java.util.Random;

public class ComparativeStudy {

  public static void main(String[] args) {
    int n = 3000; // number of rows
    int m = 3000; // number of columns
    int h = 50;
    int k = 10;
    int[][] plots = new int[n][m]; // create the 2D array

    // fill the array with random numbers between 0 and 100
    Random rand = new Random();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        plots[i][j] = rand.nextInt(101); // generates a random number between 0 and 100 (inclusive)
      }
    }

    //
    long startTime1 = System.currentTimeMillis(); // get the starting time
    //String test1 = Task1.alg1(m, n, h, plots);
    long endTime1 = System.currentTimeMillis(); // get the ending time
    long totalTime1 = endTime1 - startTime1; // calculate the total running time in milliseconds
    System.out.println("Total running time for alg1 with "+ m +" "+ n + " inputsize: " + totalTime1 + " ms");

    long startTime2 = System.currentTimeMillis(); // get the starting time
    String test2 = Task2.alg2(m, n, h, plots);
    long endTime2 = System.currentTimeMillis(); // get the ending time
    long totalTime2 = endTime2 - startTime2; // calculate the total running time in milliseconds
    System.out.println("Total running time for alg2 with "+ m +" "+ n + " inputsize: " + totalTime2 + " ms");

    long startTime3 = System.currentTimeMillis(); // get the starting time
    String test3 = Task3.alg3(m, n, h, plots);
    long endTime3 = System.currentTimeMillis(); // get the ending time
    long totalTime3 = endTime3 - startTime3; // calculate the total running time in milliseconds
    System.out.println("Total running time for alg3 with "+ m +" "+ n + " inputsize: " + totalTime3 + " ms");

    //comparativestudy for 4 5a 5b
    long startTime4 = System.currentTimeMillis(); // get the starting time
    String test4 = Task4.alg4(m, n, h, plots);
    long endTime4 = System.currentTimeMillis(); // get the ending time
    long totalTime4 = endTime4 - startTime4; // calculate the total running time in milliseconds
    System.out.println("Total running time for alg4 with "+ m +" "+ n + " inputsize: " + totalTime4 + " ms");

    long startTime5a = System.currentTimeMillis(); // get the starting time
    String test5a = Task5a.alg5(m, n, h, plots);
    long endTime5a = System.currentTimeMillis(); // get the ending time
    long totalTime5a = endTime5a - startTime5a; // calculate the total running time in milliseconds
    System.out.println("Total running time for alg5a with "+ m +" "+ n + " inputsize: " + totalTime5a + " ms");

    long startTime5b = System.currentTimeMillis(); // get the starting time
    String test5b = Task5b.alg5(m, n, h, plots);
    long endTime5b = System.currentTimeMillis(); // get the ending time
    long totalTime5b = endTime5b - startTime5b; // calculate the total running time in milliseconds
    System.out.println("Total running time for alg5b with "+ m +" "+ n + " inputsize: " + totalTime5b + " ms");

    //
    long startTime6 = System.currentTimeMillis(); // get the starting time
    //String test6 = Task6.alg6(m, n, h, k, plots);
    long endTime6 = System.currentTimeMillis(); // get the ending time
    long totalTime6 = endTime6 - startTime6; // calculate the total running time in milliseconds
    System.out.println("Total running time for alg6 with "+ m +" "+ n + " inputsize: " + totalTime6 + " ms");

    long startTime7a = System.currentTimeMillis(); // get the starting time
    //String test7a = Task7a.alg7(m, n, h,k, plots);
    long endTime7a = System.currentTimeMillis(); // get the ending time
    long totalTime7a = endTime7a - startTime7a; // calculate the total running time in milliseconds
    System.out.println("Total running time for alg7a with "+ m +" "+ n + " inputsize: " + totalTime7a + " ms");

    long startTime7b = System.currentTimeMillis(); // get the starting time
    String test7b = Task7b.alg7(m, n, h,k, plots);
    long endTime7b = System.currentTimeMillis(); // get the ending time
    long totalTime7b = endTime7b - startTime7b; // calculate the total running time in milliseconds
    System.out.println("Total running time for alg7b with "+ m +" "+ n + " inputsize: " + totalTime7b + " ms");
  }
}
