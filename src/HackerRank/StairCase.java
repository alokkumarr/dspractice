package HackerRank;

public class StairCase {
	public static void main(String[] args) {
		int n = 6;
		stairCase(n);
	}

	static void stairCase(int n) {
		String str = "#";
		for (int i = 0 ; i < n; i++) {
			System.out.printf("%" + n + "s\n", str);
			str += "#";
		}
	}

	/**
	 *
	 *
	 *      #
	 *     ##
	 *    ###
	 *   ####
	 *  #####
	 * ######
	 */
}
