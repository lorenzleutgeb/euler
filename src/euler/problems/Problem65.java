package euler.problems;

import java.math.BigInteger;
import static java.math.BigInteger.*;
import static euler.Tool.*;

class Problem65 {
	public static void main(String[] args) {
		int upperbound = 100;
		 
		BigInteger d = ONE;
		BigInteger n = ONE.add(ONE);
		 
		for (int i = 2; i <= upperbound; i++) {
		    BigInteger temp = d;
		    int c = (i % 3 == 0) ? 2 * (i / 3) : 1;
		    d = n;
		    n = d.multiply(BigInteger.valueOf(c)).add(temp);
		}
		
		System.out.println(digitSum(n));
	}
}
