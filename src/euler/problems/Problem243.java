package euler.problems;

import static euler.Tool.*;

class Problem243 {
	public static void main(String[] args) {
		int resilient = 1;
		double limit = 15499.0 / 94744.0, resilience;
		for (int d = 2; true; d++) {
			resilient = 1;
			for (int i = 2; i < d; i++) {
				if (gcd(i, d) == 1)
					resilient++;
			}
			resilience = (double)resilient / (double)d;
			if (resilience < limit) {
				System.out.println("R(" + d + ") = " + resilience + "(limit is " + limit + ")");
				return;
			}
			if (d % 10000 == 0)
				System.out.println(d);
		}
	}
}
