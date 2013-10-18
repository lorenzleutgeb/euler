package euler.problems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Problem89 {
	public static void main(String[] args) {
		Scanner sc = null;
		
		try {
			sc = new Scanner(new File("roman.txt"));
		}
		catch (FileNotFoundException e) {
			System.err.println("roman.txt not found");
			System.exit(1);
		}
		
		String line;
		int result = 0;
		while (sc.hasNextLine() && (line = sc.nextLine()) != null)
			result += line.length() - line.replaceAll("IIII|VIIII|XXXX|LXXXX|CCCC|DCCCC", "??").length();
		
		System.out.println(result);
	}
}
