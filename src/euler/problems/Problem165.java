package euler.problems;

import static euler.Tool.*;

import java.util.HashSet;

public class Problem165 {
	public static void main(String[] args) {
		long[] random = blumBlumShub(20000);
		Line[] lines = new Line[5000];
		HashSet<Point> set = new HashSet<>(4000);
		
		for (int i = 0; i < random.length; i += 4)
			lines[i / 4] = new Line(
				new Point(random[i] % 500, random[i + 1] % 500),
				new Point(random[i + 2] % 500, random[i + 3] % 500)
			);
		
		System.out.println(lines[0]);
		
		for (int i = 0; i < lines.length; i++)
			for (int j = i + 1; j < lines.length; j++)
				set.add(lines[i].trueIntersection(lines[j]));
		
		System.out.println(set.size());
	}
	
	private static class Line {
	}
}