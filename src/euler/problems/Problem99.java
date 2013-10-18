package euler.problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public final class Problem99 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader(new File("base_exp.txt")));
		
		double maximum = -1, tmp;
		String line;
		int maxline = 0, i = 0;
		while ((line = reader.readLine()) != null) {
			++i;
			String[] val = line.split(",");
			tmp = Integer.parseInt(val[1]) * Math.log10(Double.parseDouble(val[0]));
			if (tmp > maximum) {
				maximum = tmp;
				maxline = i;
			}
		}
		System.out.println(maxline);
		reader.close();
	}
}
