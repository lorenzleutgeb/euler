package euler.problems;

import static euler.Tool.*;

class Problem45 {
	public static void main(String[] args) {
		long n = 144;
		while (!isPentagonal(hexagon(n++)));
		System.out.println(hexagon(--n));
	}
}
