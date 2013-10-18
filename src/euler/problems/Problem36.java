package euler.problems;

class Problem36 {
	public static void main(String[] args) {
		System.out.println(isPalindrom("otto"));
		System.out.println(isPalindrom("oto"));
		System.out.println(isPalindrom("585"));
		
		int sum = 0;
		for (int i = 1; i < 1000000; i++)
			if (isPalindrom(Integer.toString(i, 10)) && isPalindrom(Integer.toString(i, 2))) {
				System.out.println(Integer.toString(i, 10) + "\n" + Integer.toString(i, 2));
				sum += i;
			}
				
		System.out.println(sum);
	}
	
	public static  boolean isPalindrom(String pattern) {
		if (pattern.length() < 2)
			return true;
	
		if (pattern.charAt(0) == pattern.charAt(pattern.length() - 1))
			return isPalindrom(pattern.substring(1, pattern.length() - 1));
			
		return false;
	}
}