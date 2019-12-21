package HackerRank;

import java.util.HashMap;
import java.util.Map;

public class CountingValleys {
	public static void main(String[] args) {
		int n = 8;
		String s = "DDUUDDUDUUUD";

		int walk = countingValleys(n, s);
		System.out.println(walk);
	}

	private static int countingValleys(int n, String s) {
		char[] c = s.toCharArray();
		int valley  = 0, temp = 0;
		for (char ch : c) {
			if (ch == 'U') {
				temp ++;
			} else {
				temp--;
			}
			if (temp == 0 && ch == 'U') {
				valley = valley + 1;
			}
		}
		return valley;
	}
}
