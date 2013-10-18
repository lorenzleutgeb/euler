package euler.problems;

import static euler.Tool.*;

class Problem46 {
	public static void main(String[] args) {
		int min = Integer.MAX_VALUE, tmp;
		boolean found;
		int[] primes = new int[78498];
		int ptr = 0;
		for (int n = 1; n < 1000000; n++)
			if (isPrime(n))
				primes[ptr++] = n;
		
		for (int i = 9; true; i += 2) {
			if (isPrime(i)) continue;
		
			//System.out.println("i = " + i);
		
			found = false;
		
			for (int p = 0; primes[p] <= i; p++)	 {
				//System.out.println("prime: " + primes[p]);		
				for (int j = 1; j < 100000; j++) {
					//System.out.println("square: " + j);
					tmp = primes[p] + 2 * j * j;
					if (tmp == i) {
						found = true;
						break;
					}
					else if (tmp > i) {
						break;
					}
				}
			}
				
			if (!found) {
				System.out.println(i);
				return;
			}
		}
	}
}
