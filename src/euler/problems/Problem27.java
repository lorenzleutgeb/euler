package euler.problems;

import static euler.Tool.*;

class Problem27 {
	public static void main(String[] args) {
		int[] primes = new int[168];
		int ptr = 0;
		for (int i = 0; i < 1000; i++)
			if (isPrime(i))
				primes[ptr++] = i;
	
		int product = 0, maximum = 0, n;
		for (int a = -999; a < 1000; a += 2) {
			for (int b = 0; b < primes.length; b++) {
				for (n = 0; isPrime(n * n + a * n + primes[b]); n++);

				if (n > maximum) {
					maximum = n;
					product = a * primes[b];
				}
			}
		}
		System.out.println(product);
	}
}
