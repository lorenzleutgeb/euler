package euler.problems;

import static euler.Tool.*;

class Problem35 {
	public static void main(String[] args) {
		int[] primes = new int[78498];
		int ptr = 0;
		for (int n = 1; n < 1000000; n++)
			if (isPrime(n))
				primes[ptr++] = n;
			
		int length, tmp, count, total = 0;	
		for (int i = 0; i < primes.length; i++) {
			tmp = primes[i];
			count = 0;
			length = 1 + (int)Math.log10(tmp);
			for (int x = 0; x < length; x++) {			
				tmp += (tmp % 10) * (int)Math.pow(10, length);
				tmp /= 10;

				if (isPrime(tmp))
					count++;
			}
			if (count == length)
				total++;
		}
		System.out.println(total);
	}
}
