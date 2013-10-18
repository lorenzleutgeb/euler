package euler.problems;

class Problem52 {
	public static void main(String[] args) {
		boolean is;
		boolean[] digits;
		int tmp;
				
		for (int x = 1; true; x++) {
			is = true;
			digits = new boolean[10];
			
			tmp = x;
			while (tmp != 0) {
				digits[tmp % 10] = true;
				tmp /= 10;
			}
			
			tmp = 6 * x;
			
			while (tmp != 0) {
				if (!digits[tmp % 10]) {
					is = false;
					break;
				}
				tmp /= 10;
			}
			
			if (!is) continue;
			
			tmp = 5 * x;
			
			while (tmp != 0) {
				if (!digits[tmp % 10]) {
					is = false;
					break;
				}
				tmp /= 10;
			}
			
			if (!is) continue;
			
			tmp = 4 * x;
			
			while (tmp != 0) {
				if (!digits[tmp % 10]) {
					is = false;
					break;
				}
				tmp /= 10;
			}
			
			if (!is) continue;
			
			tmp = 3 * x;
			
			while (tmp != 0) {
				if (!digits[tmp % 10]) {
					is = false;
					break;
				}
				tmp /= 10;
			}
			
			if (!is) continue;
			
			tmp = 2 * x;
			
			while (tmp != 0) {
				if (!digits[tmp % 10]) {
					is = false;
					break;
				}
				tmp /= 10;
			}
			
			if (is) {
				System.out.println(x);
				return;
			}
		}
	}
}
