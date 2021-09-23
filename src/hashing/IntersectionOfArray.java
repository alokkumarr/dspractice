package hashing;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfArray {
    public static void main(String[] args) {
        int[] arr1 = {10,20,10,20,30,4,5};
        int[] arr2 = {5,30,8,40,11,19};

        // o/p - 2
        int result = getIntersectionByNaive(arr1, arr2, arr1.length, arr2.length);
        System.out.println("Naive solution : " + result);
        int resultBest = getIntersectionByHash(arr1, arr2);
        System.out.println("Best Solution : " + resultBest);
    }


    // O(m + n)
    // O(m)
    private static int getIntersectionByHash(int[] arr1, int[] arr2) {
        int result = 0;
        Set<Integer> set = new HashSet<>();
        for (int data : arr1) {
            set.add(data);
        }

        for (int data : arr2) {
            if (set.contains(data)){
                result ++;
                set.remove(data);
            }
        }

        return result;
    }

    // O (n^2)
    // space O(1)
    private static int getIntersectionByNaive(int[] arr1, int[] arr2, int m, int n) {
        int result = 0;
        for (int i = 0; i < m; i ++) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (arr1[i] == arr1[j]) {
                    flag = true;
                    break;
                }
            }
            // check if element present
            if (flag) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (arr1[i] == arr2[j]) {
                    result ++;
                    break;
                }
            }
        }
        return result;
    }


}
