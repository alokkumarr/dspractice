package HackerRank;

import java.util.*;

public class FindNumberOfPair {
	public static void main(String[] args) {
		int n = 100;
		String s = "50 49 38 49 78 36 25 96 10 67 78 58 98 8 53 1 4 7 29 6 59 93 74 3 67 47 12 85 84 40 81 85 89 70 33 66 6 9 13 67 75 42 24 73 49 28 25 5 86 53 10 44 45 35 47 11 81 10 47 16 49 79 52 89 100 36 6 57 96 18 23 71 11 99 95 12 78 19 16 64 23 77 7 19 11 5 81 43 14 27 11 63 57 62 3 56 50 9 13 45";

		String[]  s1 = s.split(" ");
		int[] ar = new int[n];
		for (int i = 0; i < n; i ++) {
			ar[i] = Integer.valueOf(s1[i]);
		}


		System.out.println(sockMerchant(n, ar));
	}

	// Complete the sockMerchant function below.
	static int sockMerchant(int n, int[] ar) {
		int pair = 0;
		if (ar != null && ar.length > 0){
			Set<Integer> temp = new HashSet<>();
			for (int a : ar) {
				if (temp.contains(a)) {
					temp.remove(a);
					pair++;
				} else {
					temp.add(a);
				}
			}
		}
		return pair;
	}

	// Complete the sockMerchant function below.
	static int sockMerchant2(int n, int[] ar) {
		int pair = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (Integer a : ar) {
			Integer value = map.get(a);
			if (value == null){
				map.put(a, 1);
			} else {
				map.put(a, value + 1);
			}
		}
		//System.out.println(map);
		Set<Integer> s = map.keySet();
		for (Integer a : s) {
			pair += map.get(a) / 2;
		}
		return pair;
	}

	// Complete the sockMerchant function below.
	static int sockMerchant1(int n, int[] ar) {
		Arrays.sort(ar);
		System.out.println(Arrays.toString(ar));

		int pair = 0, tempCount = 0;
		for (int i = 1; i < ar.length; i++) {
			int x = ar[i];
			int y = ar[i - 1];

			if (x == y) {
				if (tempCount == 0) {
					tempCount = tempCount + 1;
					pair = pair + 1;
				} else {
					tempCount = 0;
				}
			}
		}
		return pair;
	}

	/**
	 *
	 * 20
	 * 4 5 5 5 6 6 4 1 4 4 3 6 6 3 6 1 4 5 5 5
	 * o/p - 9
	 *
	 *
	 * 15
	 * 6 5 2 3 5 2 2 1 1 5 1 3 3 3 5
	 *
	 * o/p - 6
	 *
	 *
	 * 100
	 * 44 55 11 15 4 72 26 91 80 14 43 78 70 75 36 83 78 91 17 17 54 65 60 21 58 98 87 45 75 97 81 18 51 43 84 54 66 10 44 45 23 38 22 44 65 9 78 42 100 94 58 5 11 69 26 20 19 64 64 93 60 96 10 10 39 94 15 4 3 10 1 77 48 74 20 12 83 97 5 82 43 15 86 5 35 63 24 53 27 87 45 38 34 7 48 24 100 14 80 54
	 *
	 * o/p - 30
	 *
	 * 100
	 * 50 49 38 49 78 36 25 96 10 67 78 58 98 8 53 1 4 7 29 6 59 93 74 3 67 47 12 85 84 40 81 85 89 70 33 66 6 9 13 67 75 42 24 73 49 28 25 5 86 53 10 44 45 35 47 11 81 10 47 16 49 79 52 89 100 36 6 57 96 18 23 71 11 99 95 12 78 19 16 64 23 77 7 19 11 5 81 43 14 27 11 63 57 62 3 56 50 9 13 45
	 *
	 *o/p - 28
	 *
	 *
	 */
}
