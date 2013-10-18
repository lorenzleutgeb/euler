package euler.problems;

import java.util.HashSet;

class Problem44 {
	public static void main(String[] args) {
		HashSet<Long> set = new HashSet<>(10000000);
		
		for (long i = 0; i < 10000000; i++)
			set.add(i * (3 * i - 1) / 2);
			
		for (Long item : set) {
			
		}
	}
}
