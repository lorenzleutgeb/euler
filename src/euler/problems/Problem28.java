package euler.problems;

class Problem28 {
	public static void main(String[] args) {
		int square = 1001;
		int i = square / 2, j = square / 2, n = 2, size = 3, count = 0, sum = 1;
		
		j++;
		
		while (!(i == 0 && j == square)) {
			if (i == j || i == square - j - 1)
				sum += n;
			
			count++;
			if (count == (size - 1) * 4 + 1) {
				i++;
				size += 2;
				count = 1;
			}
			else if (count < size - 1) {
				i++;
			}
			else if (count < 2 * size - 2) {
				j--;
			}
			else if (count < 3 * size - 3) {
				i--;
			}	
			else {
				j++;
			}
			n++;
		}
		
		System.out.println(sum);
	}
}
