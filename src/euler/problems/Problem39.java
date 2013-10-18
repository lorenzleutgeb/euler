package euler.problems;

public class Problem39 {

	public static void main(String[] args) {
		int count = 0, n = 0, max = -1;
		for (int i = 1; i <= 1000; i++) {
			count = 0;
			for (int a = 1; a < i; a++) {
				for (int b = 1; b < a; b++) {
					double c = Math.hypot(a, b); 
					int sum = a + b + (int)c;
					if (sum >= i) {
						if (sum == i && c % 1.0 == 0.0) {
							count++;
						}
						break;
					}
				}
			}
			if (count > max) {
				max = count;
				n = i;
			}
		}
		System.out.println(n);
	}

}
