package euler.problems;

import java.util.Arrays;

import static euler.Tool.*;

class Problem49 {
	public static void main(String[] args) {
//		int[] primes = new int[1061];
//		int ptr = 0;
		
		for (int n = 1000; n < 3400; n++)
			if (isPrime(n))
				if (isPermutation(String.valueOf(n).toCharArray(), String.valueOf(n + 3300).toCharArray()) && isPermutation(String.valueOf(n).toCharArray(), String.valueOf(n + 6600).toCharArray()))
					if (isPrime(n + 3300) && isPrime(n + 6600)) {
						System.out.println(n + "" + (n + 3300) + "" + (n + 6600));
					}
//				primes[ptr++] = n;
		
		
/*		int[] permutations = new int[3];
		for (int i = 0; i < primes.length - 1; i++) {
			ptr = 0;
			permutations[ptr] = primes[i];
			
			for (int j = i + 1; j < primes.length && ptr < 2; j++)
				if (isPermutation(String.valueOf(primes[i]).toCharArray(), String.valueOf(primes[j]).toCharArray()))
					permutations[++ptr] = primes[j];

			if (permutations[2] - permutations[1] == permutations[1] - permutations[0]) {
				System.out.println(permutations[0] + "" + permutations[1] + "" + permutations[2]);
				return;
			}
		} */
	}
	
	private static boolean isPermutation(char[] a, char[] b) {
		if (a.length != b.length)
			return false;
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		for (int i = 0; i < a.length; i++)
			if (a[i] != b[i])
				return false;
		
		return true;
	}
}
