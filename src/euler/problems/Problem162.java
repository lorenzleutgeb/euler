package euler.problems;

import java.math.BigInteger;
class Problem162 {
	public static void main(String[] args) {
		String tmp = "";
		int count = 0;
		BigInteger limit = new BigInteger("FFFFFFFFFFFFFFFF", 16);
		for (BigInteger i = new BigInteger("100", 16); i.compareTo(limit) <= 0; i = i.add(BigInteger.ONE)) {
			tmp = i.toString(16);
			
			if (tmp.contains("a"))
				if (tmp.contains("0"))
					if (tmp.contains("1"))
						count++;
		}
		System.out.println(Integer.toString(count, 16));
	}
}