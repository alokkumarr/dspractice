package HackerRank.simple;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SampleTripletCompare {

  // Complete the compareTriplets function below.
  static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
    List<Integer> compare = new ArrayList<>();
    int al = 0;
    int bo = 0;

    String s = "test";
    return compare;
  }


  static long aVeryBigSum(long[] ar) {
    long sum = 0l;
    if (ar.length > 0) {
      for (long n : ar) {
        sum += n;
      }
    }
    return sum;
  }


  public static int diagonalDifference(List<List<Integer>> arr) {
    // Write your code here
    int d1 = 0, d2 = 0;
    int n = arr.size();
    for (int i = 0, j = n - 1; i < n; i++, j--) {
      d1 += arr.get(i).get(i);
      d2 += arr.get(j).get(i);
    }
    return Math.abs(d1 - d2);
  }


  static void plusMinus(int[] arr) {

    int n = arr.length;
    if (n == 0) {
      System.out.println("Infinite");
    }

    int positiveCount = 0, negCount = 0, zeros = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] > 0) positiveCount += 1;
      else if (arr[i] < 0) negCount += 1;
      else zeros += 1;
    }
    System.out.println(new DecimalFormat("#.#####").format((double) positiveCount / n));
    System.out.println(new DecimalFormat("#.#####").format((double) negCount / n));
    System.out.println(new DecimalFormat("#.#####").format((double) zeros / n));
  }




  static void staircase(int n) {

    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < n; i++){
      builder.append(" ");
    }

    int j = 0;
    for (int i = 1; i <= n; i++) {
      builder.replace(builder.length() - i, builder.length() - j, "#");
      System.out.println(builder);
      j++;
    }
}

  static void miniMaxSum(int[] arr) {
    int max = 0, min = arr[0];
    int n = arr.length;
    for (int i = 0; i<n; i++) {
      if (arr[i] > max) max = arr[i];
      else if(arr[i] < min) min = arr[i];
    }

    long minSum = 0, maxSum = 0;
    for (int i = 0; i<n; i++) {

      if (arr[i] != min) {
        maxSum += arr[i];
      }

      if (arr[i] != max) {
        minSum += arr[i];
      }
    }

    System.out.print(minSum + "  ");
    System.out.print(maxSum);

  }


  static int birthdayCakeCandles(int[] ar) {

    int max = ar[0];
    for (int i = 0; i < ar.length; i ++) {
      if (ar[i] > max) max = ar[i];
    }

    System.out.println(max);

    int maxCountCandle = 0;
    for (int i = 0; i < ar.length ; i ++) {
      if (ar[i] == max){
        maxCountCandle += 1;
      }
    }
    System.out.println(maxCountCandle);
    return maxCountCandle;
  }


  /*
   * Complete the timeConversion function below.
   */
  static String timeConversion(String s) {
    /*
     * Write your code here.
     */
/*
    char[] inChar = s.toCharArray();
    char[] out = Arrays.copyOfRange(inChar, 0, 8);
    if(inChar[8] == 'A' && s.substring(0,2) == "12") {
      out[0] = 0;
      out[1] = 0;
    }
    else if(inChar[8] =='P' && s.substring(0,2) != "12") {
      String s1 = "" + (Integer.parseInt(s.substring(0,2)) + 12);
      char[] f = s1.toCharArray();
      out[0] = f[0];
      out[1] = f[1];
    }
     System.out.println(out);
    return new String(out);*/

    if(s.endsWith("AM")){
      if(s.substring(0, 2).equals("12"))
        return "00" + s.substring(2,8);

      return s.substring(0, 8);
    }else{
      if(s.substring(0, 2).equals("12"))
        return s.substring(0, 8);
      return Integer.valueOf(s.substring(0,2)) + 12 + s.substring(2,8);
    }
  }

  public static void main(String[] args) {
    // plusMinus(new int[]{-4, 3, -9, 0, 4, 1});
    // staircase(6);
    // miniMaxSum(new int[]{140537896, 243908675, 670291834, 923018467, 520718469});
    // birthdayCakeCandles(new int[]{3, 2, 1, 3});
    System.out.println(timeConversion("07:05:45PM"));
  }
}
