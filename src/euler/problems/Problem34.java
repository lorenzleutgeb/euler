package euler.problems;

class Problem34 {
	public static void main(String[] args) {
		int sum = 0, n, tmp, total = 0, fac = 1;
		for (int i = 3; true; i++) {
			n = i;
			sum = 0;
			while (n != 0) {
				tmp = n % 10;
				fac = 1;
				for (int j = 1; j <= tmp; j++)
					fac *= j;

				sum += fac;
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
