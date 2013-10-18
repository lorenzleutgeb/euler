package euler.problems;

public class Problem206 {
	public static void main(String[] args) {
		System.out.println();
		for (long i = 100000000; i * i < 9000000000000000000L; i += 10) {
			//System.out.println(i);
			if (String.valueOf(i * i).matches("1[0-9]2[0-9]3[0-9]4[0-9]5[0-9]6[0-9]7[0-9]8[0-9]9[0-9]0")) {
				System.out.println(i);
				return;
			}
		}
	}
}
