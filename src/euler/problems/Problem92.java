package euler.problems;

import static euler.Tool.*;

class Problem92 {
	public static void main(String[] args) {
		int n, j, count = 0;
		for (int i = 2; i < 10000000; i++) {
			n = i;
			j = 0;
			while (true) {
				if (n == 1 || n == 89)
					break;
				else if (j > 1000)
					break;

				n = addSquareDigits(n);
			}
			if (n == 89) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}
