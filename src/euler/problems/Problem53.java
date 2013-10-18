package euler.problems;

import static euler.Tool.*;

class Problem53 {
	public static void main(String[] args) {
		int count = 0;
		for (int n = 1; n <= 100; n++)
			for (int r = 1; r <= n; r++)
				if (limitedBinomial(n, r, 1000000))
					count++;
		
		System.out.println(count);
	}
}
