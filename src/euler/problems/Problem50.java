package euler.problems;

import static euler.Tool.*;

class Problem50 {
	public static void main(String[] args) {
		int[] primes = new int[78498];
		int ptr = 0;
		for (int n = 1; n < 1000000; n++)
			if (isPrime(n))
				primes[ptr++] = n;

		int sum = 0, max = 0, prime = 0, count = 0;
/*		
		for (int j = 0; j < primes.length; j++) {
			sum = 0;
			for (int i = j; i < primes.length && sum < 1000000; i++) {
				if (isPrime((sum += primes[i])))
					System.out.println(sum + " " + i + " " + j);
			}
		} */

		for (int i = primes.length - 1; i > -1; i--) {
			for (int k = 0; k < primes.length; k++) {
				sum = 0;
				count = 0;
				for (int j = k; j < primes.length; j++) {
					sum += primes[j];
					count++;
					if (sum == primes[i]) {
						//System.out.println(primes[i] + " can be written as the sum of " + count + " consecutive primes.");
						if (count > max) {
							max = count;
							prime = primes[i];
						}
					}
					else if (sum > primes[i]) {
						break;
					}
				}
			}
		}
		System.out.println(prime);
	}
}
