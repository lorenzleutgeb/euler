package euler.problems;

import static euler.Tool.*;

class Problem24 {

	private static String lexicographicPermutation(String init, int n) {
		if (init.length() == 1)
			return init;

		String out = "";
		int elements = init.length();
		
		for (int i = 0; i < init.length(); i++) {
		
			int partition = factorial(elements) / elements;
			int index = (int)Math.ceil(n / partition);
		
			out += init.substring(index - 1, index);
		
		}
		
		return null;
	}
}
