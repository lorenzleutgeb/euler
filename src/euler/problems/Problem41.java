package euler.problems;

import static euler.Tool.*;

class Problem41 {
	public static void main(String[] args) {
		boolean is;
		boolean[] digits;
		int tmp, index;
		for (int n = 987654321; n > 1; n++) {
			if (!isPrime(n))
				continue;
			
			tmp = n;
			digits = new boolean[9];
			is = true;
			
			while (tmp != 0 && is) {
				index = tmp % 10 - 1;
				
				if (index == -1) {
					is = false;
					break;
				}
					
				if (digits[index]) {
					is = false;
					break;
				}
					
				digits[index] = true;
				
				tmp /= 10;
			}
			
			if (is) {
				System.out.println(n);
				return;
			}
		}
	}
}
