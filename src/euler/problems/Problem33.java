package euler.problems;

import static euler.Tool.*;

class Problem33 {
	public static void main(String[] args) {
		int a, b, gcd, np = 1, dp = 1;
		
		for (int n = 10; n < 100; n++)
		for (int d = n + 1; d < 100; d++) {
			if (n % 10 == d / 10) {
				a = n / 10;
				b = d % 10;
			}
			else if (n / 10 == d % 10) {
				a = n % 10;
				b = d / 10;
			}
			else continue;
			
			gcd = gcd(a, b);
			a = a / gcd;
			b = b / gcd;
			
			gcd = gcd(d, n);
			
			if (n / gcd == a && d / gcd == b) {
				np *= n;
				dp *= d;
				System.out.println(n + " / " + d);
			}
		}
		
		System.out.println(dp / gcd(np, dp));
	}
}
