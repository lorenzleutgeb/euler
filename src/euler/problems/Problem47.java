package euler.problems;

import java.util.HashSet;

import static euler.Tool.*;

class Problem47 {
	public static void main(String[] args) {
		int[] primes = new int[78498];
		int ptr = 0, tmp, count = 0;
		HashSet<Integer> set = new HashSet<>();
		for (int n = 1; n < 1000000; n++) {
			if (isPrime(n)) {
				count = 0;
				primes[ptr++] = n;
				continue;
			}
			tmp = n;
			set.clear();
			while (!isPrime(tmp) && tmp != 1) {
				int i = 0;
				
				while (tmp % primes[i++] != 0) ;
				
				tmp /= primes[i - 1];
				
				set.add(primes[i - 1]);
			}
			if (tmp != 1)
				set.add(tmp);
			
			//System.out.println("Factorizaion of " + n + ": " + set.toString());
				
			if (set.size() == 4)
				count++;
			else
				count = 0;

			if (count == 4) {
				System.out.println(n - 3);
				return;
			}
		}
	}
}
