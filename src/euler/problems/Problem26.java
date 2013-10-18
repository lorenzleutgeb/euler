package euler.problems;

import static euler.Tool.*;

import java.util.ArrayList;
import java.util.List;

class Problem26 {
	public static void main(String[] args) {
		int length = 0, d = -1, value, position;
		int[] remainders;
		
		for (int i = 999; i > 1 && length < i; i--) {
			remainders = new int[i];
			value = 1;
			position = 0;
			
			while (remainders[value] == 0 && value != 0) {
				remainders[value] = position++;
				value = (value * 10) % i;
			}
			
			if (position - remainders[value] > length) {
				length = position - remainders[value];
				d = i;
			}
		}
		System.out.println(d);
	}
}
