package euler.problems;

public class Problem17 {
	static String[] normals = { "?", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
	static int[] normal =     {   0,     3,     3,       5,      4,      4,     3,       5,       5,      4 };
	static String[] teenss = { "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
	static int[] teens =  {        3,        6,        6,          8,          8,         7,         7,           9,          8,          8 };
	static String[] tenthss = { "?", "?",                  "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };
	static int[] tenths = { Integer.MIN_VALUE, Integer.MIN_VALUE, 6,        6,       5,       5,       5,         7,        6,        6 };
	
	public static void main(String args[]) {
		System.out.println(len(342));
		System.out.println(len(115));
	
		int len = 11;

		for (int i = 1; i <= 999; i++) {
			System.out.println(i);
			len += len(i);
		}
		
		System.out.println(len);
	}

	public static int len(int i) {
		int len = 0;
		if (i >= 100) {
			len += normal[i / 100] + 7;
			System.out.print(normals[i / 100] + "hundred ");
		}
		if (i % 100 >= 20) {
			len += tenths[(i % 100) / 10] + normal[(i % 100) % 10];
			System.out.println((i > 100 ? "and " : "") + tenthss[(i % 100) / 10] + normals[(i % 100) % 10]);
			
			if (i > 100) {
				len += 3;
			}
		}
		else if (i % 100 >= 10) {
			len += teens[(i % 100) % 10];
			System.out.println((i > 100 ? "and " : "") + teenss[(i % 100) % 10]);
			
			if (i > 100) {
				len += 3;
			}
		}
		else if (i % 100 > 0) {
			len += normal[i % 10];
			System.out.println((i > 100 ? "and " : "") + normals[i % 10]);
			
			if (i > 100) {
				len += 3;
			}
		}
		return len;
	}
}