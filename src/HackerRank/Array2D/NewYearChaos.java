package HackerRank.Array2D;

public class NewYearChaos {
	public static void main(String[] args) {
		int q[] = {2, 1, 5, 3, 4};

		minimumBribes(q);
	}


	static void  minimumBribes(int[] q) {
		int[] outputFrequencyDistribution = new int[q.length + 1];
		boolean chaos = false;
		boolean finished = false;
		int count = 0;
		while (!finished) {
			finished = true;
			for (int a = 0; a < q.length - 1; a++) {
				if (q[a] > q[a + 1]) {
					outputFrequencyDistribution[q[a]]++;
					if (outputFrequencyDistribution[q[a]] > 2) {
						finished = true;
						chaos = true; // if it's too chaotic, break out
						break;
					}
					count++;
					int temp = q[a];
					q[a] = q[a + 1];
					q[a + 1] = temp;
					finished = false;
				}
			}
		}
		if (chaos) {
			System.out.println("Too chaotic");
		} else {
			System.out.println(count);
		}
	}

	// Complete the minimumBribes function below.
	static void minimumBribes1(int[] q) {
		int bribe = 0;
		boolean chaotic = false;

		for (int i = 0; i < q.length; i++) {
			// a chaotic situation
			if ((q[i] - (i + 1)) > 2) {
				chaotic = true;
				return;
			}

			for (int j = Math.max(0, q[i] - 2 ); j < i; j++)
				if (q[j] > q[i])
					bribe++;
		}

		if (chaotic)
			System.out.println("Too chaotic");
		else
			System.out.println(bribe);
		//System.out.println("count" + count);
	}
}