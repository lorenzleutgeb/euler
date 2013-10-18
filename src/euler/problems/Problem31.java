package euler.problems;

class Problem31 {
	public static void main(String[] args) {
		int count = 0;
		for (int a = 0; a <= 1; a++)
		for (int b = 0; b <= 2; b++)
		for (int c = 0; c <= 4; c++)
		for (int d = 0; d <= 10; d++)
		for (int e = 0; e <= 20; e++)
		for (int f = 0; f <= 40; f++)
		for (int g = 0; g <= 100; g++)
		for (int h = 0; h <= 200; h++) {
			if (h + 2 * g + 5 * f + 10 * e + 20 * d + 50 * c + 100 * b + 200 * a == 200)
				count++;
		}
		System.out.println(count);
	}
}
