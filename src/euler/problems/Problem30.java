package euler.problems;

class Problem30 {
	public static void main(String[] args) {
		int sum = 0, n, tmp, total = 0;
		for (int i = 2; true; i++) {
			n = i;
			sum = 0;
			while (n != 0) {
				tmp = n % 10;
				sum += tmp * tmp * tmp * tmp * tmp;
				n /= 10;
			}
			if (sum == i) {
				total += sum;
				System.out.println(total);
			}
		}
		//System.out.println(total);
	}
}
