package euler.problems;

import java.math.BigInteger;
import static java.math.BigInteger.*;
import java.util.Stack;
import static euler.Tool.*;

class Problem55 {
	public static void main(String[] args) {
		BigInteger limit = BigInteger.valueOf(10000L);
		int count = 0;
		for (BigInteger i = ONE; i.compareTo(limit) < 0; i = i.add(ONE))
			if (isLychrel(i))
				count++;		

		System.out.println(count);
	}
}
