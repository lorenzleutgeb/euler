package euler.problems;

import java.util.LinkedList;

import static euler.Tool.*;

class Problem37 {
	public static void main(String[] args) {
		int sum = 0, tmp, count = 0;
		boolean is;
		LinkedList<Integer> list;
		for (int i = 11; true; i++) {
			if (!isPrime(i)) continue;
						
			int length = (int)Math.log10(i);
			list = new LinkedList<Integer>();//(1 + length);
			
			tmp = i;
			is = true;
			
			for (int a = 0; a < length; a++) {
				list.add(tmp % 10);
				tmp /= 10;

				if (!isPrime(tmp)) {
					is = false;
					break;
				}
			}
			
			if (!is) continue;
			
			tmp = 0;
			while (!list.isEmpty())
				if (!isPrime(tmp += list.poll() * Math.pow(10, length - list.size() - 1))) {
					is = false;
					break;
				}
			
			if (is) {
				sum += i;
				if (++count == 11) {
					System.out.println(sum);
					return;
				}
			}
		}
	}
}
