package HackerRank;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TripletSum {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(removeDuplicates(new int[]{1,1,1,1,1,12,2,2,2,3})));
  }

  static long tripletSum1(int a[], int b[], int c[]) {
    long distinctTripletCount = 0;

    a = removeDuplicates(a);
    b = removeDuplicates(b);
    c = removeDuplicates(c);

    Arrays.sort(a);
    Arrays.sort(b);
    Arrays.sort(c);

    for (int q : b) {
      long c1 = getValidIndex(a, q) + 1;
      long c2 = getValidIndex(c, q) + 1;
      distinctTripletCount += c1 + c2;
    }

    return distinctTripletCount;
  }

  private static long getValidIndex(int[] a, int q) {
    int low = 0;
    int high = a.length -1;
    int count = -1;
    while (low <= high){
      int mid = low + (high - low)/2;
      if (a[mid] <= q){
        count = mid + 1;
      } else {
        high = mid-1;
      }
    }
    return count;
  }

  public static int[] removeDuplicates(int[] array) {
    // add the ints into a set
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < array.length; i++) {
      set.add(array[i]);
    }

    // copy the elements from the set into an array
    int[] result = new int[set.size()];
    int i = 0;
    for (Integer u : set) {
      result[i++] = u;
    }
    return result;
  }

  static long triplets(int[] a, int[] b, int[] c) {
    int[] ar = Arrays.stream(a).sorted().distinct().toArray();
    int[] br = Arrays.stream(b).sorted().distinct().toArray();
    int[] cr = Arrays.stream(c).sorted().distinct().toArray();

    long left = 0;
    long right = 0;
    int l = 0;
    int r = 0;
    long sum = 0;

    for(int i=0; i<br.length; i++) {
      while(l<ar.length&&ar[l]<=br[i]) {
        left++;
        l++;
      }
      while(r<cr.length&&cr[r]<=br[i]) {
        right++;
        r++;
      }
      sum += left*right;
    }
    return sum;
  }

}