package euler.problems;

import java.math.BigInteger;
import java.util.HashSet;

public class Problem29 {
	public static void main(String[] args) {
		HashSet<BigInteger> set = new HashSet<BigInteger>();
		
		for (BigInteger a = BigInteger.ONE.add(BigInteger.ONE); a.compareTo(BigInteger.valueOf(101L)) < 0; a = a.add(BigInteger.ONE)) {
			for (int b = 2; b < 101; b++) {
				set.add(a.pow(b));
				System.out.println(a + " " + b);
			}
		}
		
		System.out.println(set.size());
	}
}