package euler.problems;

import static euler.Tool.*;

class Problem123 {
	public static void main(String[] args) {	
		long[] primes = new long[5761455];
		int ptr = 0;
		for (long n = 1; n < 1000000; n++)
			if (isPrime(n))
				primes[ptr++] = n;
					
		System.out.println("have primes");
		
		long mod;
		for (int i = 0; i < 100; i++) {
			mod = primes[i] * primes[i];
			long a = (primes[i] - 1);
			long b = (primes[i] + 1);
			for (int j = 0; j < (i + 1); j++) {
				a = (a * a) % mod;
				b = (b * b) % mod;
			}
		
			System.out.println((i + 1) + " " + ((a + b) % mod));
		}
	}
}
