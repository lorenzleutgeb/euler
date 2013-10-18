package euler.problems;

import java.util.HashSet;
import java.util.Arrays;

class Problem32 {
	public static void main(String[] args) {
		boolean[] digits;
		HashSet<Integer> set = new HashSet<>();
		boolean is = true;
		int len, p, tmp, sum = 0, index;
		for (int a = 1; true; a++) {
			for (int b = a; true; b++) {
				//int a = 39, b = 186;
				p = a * b;
				len = 3 + (int)Math.log10(a) + (int)Math.log10(b) + (int)Math.log10(p);
				if (len > 9)
					break;
				else if (len == 9) {
					if (set.contains(p))
						continue;

					digits = new boolean[9];
					tmp = a;
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
					tmp = b;
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
					tmp = p;
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
					if (is && digits[0] && digits[1] && digits[2] && digits[3] && digits[4] && digits[5] && digits[6] && digits[7] && digits[8]) {
						sum += p;
						set.add(p);
						System.out.println(sum);
					}
				}
			}
		}
	}
}
