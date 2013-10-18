package euler.problems;

import java.math.BigInteger;
import static java.math.BigInteger.*;

public class Problem188 {
	public static void main(String[] args) {
		System.out.println(hyperModPow(valueOf(1777L), 1855, valueOf(100000000L)));
	}
	
	private static BigInteger hyperModPow(BigInteger a, int exp, BigInteger m) {
		if (exp == 1)
			return a;
		
		return a.modPow(hyperModPow(a, exp - 1, m), m);
	}
}
