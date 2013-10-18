package euler.problems;

import static euler.Tool.*;

public class Problem38 {

	public static void main(String[] args) {
		System.out.println(is1to9Pandigital(192, 3, 48576));
		System.out.println(concat(192, 3, 576));

		int largest = 0, product;
		for (int i = 1; true; i++) {
			product = i;
			for (int n = 2; true; n++) {
				product = concat(product, i * n);
				
				if (product > 987654321) {
					break;
				}
				else if (is1to9Pandigital(product)) {
					if (product > largest) {
						largest = product;
						System.out.println(product);
					}
					break;
				}
			}
		}
	}
}
