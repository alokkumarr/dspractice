public class FibTimeComplexicity {
	public static void main(String[] args) {
		int fib = fib(7);

		System.out.println("Fibo: " + fib);
	}

	private static int fib(int n) {
		if (n == 0 || n == 1)
			return n;
		else
			return fib(n - 1) + fib(n - 2);
	}

	// This section only finds the Fibonacci of
	// an integer number, and returns a long value
	// which is the result.
	public static long findsFibo(int n) {
		long fn_2 = 1;  // Fib -1
		long fn_1 = 0;  // Fib 0
		long fn = 0;  // Adding the last 2

		for (int i = 1; i <= n; i++) {
			fn = fn_2 + fn_1;
			fn_2 = fn_1;
			fn_1 = fn;
		}
		return fn;
	}
}
