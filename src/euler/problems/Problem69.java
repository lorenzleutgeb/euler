package euler.problems;

import static euler.Tool.*;

class Problem69 {
	public static void main(String[] args) {
		int max = 0;
		int n = 0;
		int tmp;
		for (int i = 3; i <= 1000000; i++) {
			tmp = isPrime(i) ? i / (i - 1) : i / totient(i);
			
			if (i % 10000 == 0)
				System.out.println(i);
			
			if (tmp > max) {
				n = i;
				max = tmp;
			}
		}
		System.out.println(max);
	}
}
