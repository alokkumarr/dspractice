package HackerRank;

public class RepeatedString {

	public static void main(String[] args) {
		long n = 1000000000;
		String s = "a";

		System.out.println(repeatedString(s, n));
	}

	// Complete the repeatedString function below.
	static long repeatedString(String s, long n) {

		final long quotient = n/s.length();
		final long remainder = n%s.length();

		long rep = 0;
		char ch = 'a';

		if((s.length() == 1) && (s.charAt(0) == 'a')){
			return n;
		}

		for (int i = 0; i< s.length(); i ++)
			if (s.charAt(i) == ch)
				rep++;

		// count the repetion
		rep = rep * quotient;

		for (int i = 0; i < remainder; i ++)
			if (s.charAt(i) == ch)
			rep++;

		//System.out.println(s.length());
		return rep;
	}
}
