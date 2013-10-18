package euler.problems;

import java.util.Stack;

class Problem40 {
	public static void main(String[] args) {
		int length = 0, result = 1, tmp, next = 10;
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 1; length <= 1000000; i++) {
			tmp = i;
			do {
				stack.push(tmp % 10);
			} while ((tmp /= 10) != 0);
			
			while (!stack.empty()) {
				tmp = stack.pop();
				length++;
				//System.out.print(tmp);
				
				if (length == next) {
					result *= tmp;
					next *= 10;
					System.out.println(length + " " + (tmp % 10));
				}
			}
		}
		
		System.out.println(result);
	}
}
