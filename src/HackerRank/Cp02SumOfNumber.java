package HackerRank;

import java.util.HashMap;
import java.util.Map;

public class Cp02SumOfNumber {
	public static void main(String[] args) {
		int num = 7;
		int arr[] = {-3,1,2,9,8,4,10};
		int[] res = findSumOfIndex(num, arr);

		System.out.println(res[1] + ", " + res[0]);
	}

	private static int[] findSumOfIndex(int num, int arr[]) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i =0; i < arr.length; i ++) {
			int delta = num - arr[i];
			if (map.containsKey(delta)) {
				return new int[]{i, map.get(delta)};
			}	else {
				map.put(arr[i], i);
			}
		}
		return null;
	}
}