package euler.problems;

import java.util.HashSet;

import static euler.Tool.*;

public class Problem23 {
	public static void main(String[] args) {
		HashSet<Integer> abundants = new HashSet<Integer>();
		
		int count = 0;
		
		for (int i = 0; i < 28124; i++) {
			if (isAbundant(i))
				abundants.add(i);
		}

		for (int i = 1; i < 28124; i++) {
			if (i % 1000 == 0) {
				System.out.println(i);
			}
			boolean can = false;
			for (Integer a : abundants) {
				if (abundants.contains(i - a)) {
					can = true;
					break;
				}
			}
			if (!can)
				count += i;
		}
				
		System.out.println(count);
	}
}