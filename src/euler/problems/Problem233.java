package euler.problems;

import static euler.Tool.*;

public abstract class Problem233 {
	public static void main(String[] args) {
		double n = 5000.0, x, y;
		
		int count = 0;
		
		for (double i = 0; i < 360.0; i += 1) {
			x = n + (n * Math.sin(i));
			y = n + (n * Math.cos(i));
			
			System.out.println(x + " " + y);
			
			if (x % 1.0 == 0.0)
				if (y % 1.0 == 0.0)
					count++;
		}
		
		System.out.println(count);
	}
}
