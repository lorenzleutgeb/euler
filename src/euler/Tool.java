package euler;



import static java.math.BigInteger.TEN;
import static java.math.BigInteger.ZERO;

import java.math.BigInteger;
import java.util.Arrays;

import euler.problems.Problem165.Line;
import euler.problems.Problem165.Point;

public abstract class Tool {
	public static boolean isLychrel(BigInteger n) {
		for (int i = 0; i < 50; i++)
			if (isPalindromic(n = n.add(reverse(n))))
				return false;
		return true;
	}
	
	public static boolean isPalindromic(BigInteger n) {
		return reverse(n).equals(n);
	}
	
	public static BigInteger reverse(BigInteger n) {
		BigInteger result = ZERO;

		BigInteger[] tmp;
		while (true) {
			tmp = n.divideAndRemainder(TEN);
			
			result = result.add(tmp[1]);
			
			if (!tmp[0].equals(ZERO)) {
				result = result.multiply(TEN);
				n = tmp[0];
			}
			else {
				return result;
			}
		}
	}
	
	public static int digitSum(BigInteger n) {
		int result = 0;
		
		BigInteger[] tmp;
		while (true) {
			tmp = n.divideAndRemainder(TEN);
			
			result += tmp[1].intValue();
			
			if (!tmp[0].equals(ZERO)) {
				n = tmp[0];
			}
			else {
				return result;
			}
		}
	}
	
	public static boolean isPrime(long n) {
		if (n < 2)
			return false;
		else if (n < 4)
			return true;
		else if (n % 2 == 0)
			return false;
		else if (n < 9)
			return true;
		else if (n % 3 == 0)
			return false;
	
		long r = (long)Math.floor(Math.sqrt(n)), f = 5;

		do {
			if (n % f == 0)
				return false;
			else if (n % (f + 2) == 0)
				return false;
		}
		while ((f += 6) <= r);
		
		return true;
	}
	
	public static int factorial(int n) {
		int result = 1;

		for (int i = 1; i <= n; i++)
			result *= i;
			
		return result;
	}
	
	public static int totient(int n) {
		int result = 0;
		for (int i = 1; i < n; i++)
			if (n % i != 0)
				result++;
				
		return result;
	}

	public static boolean limitedBinomial(int n, int k, int limit) {
		long noverk = 1;

		if (2 * k < n)
			k = n - k;

		for (int i = 1; i <= n - k; i++)
			if ((noverk = (noverk * (i + k)) / i) > limit)
				return true;
		
		return false;
	}
	
	public static int addSquareDigits(int n) {
		int result = 0;
		
		while (n != 0) {
			result += Math.pow(n % 10, 2);
			n /= 10;
		}
		
		return result;
	}
	
	public static int fromRoman(String roman) {
		int value = 0;
		char[] array = roman.toCharArray();
		for (char item : array) switch (item) {
			case 'I':
				value += 1;
				break;
			case 'V':
				value += 5;
				break;
			case 'X':
				value += 10;
				break;
			case 'L':
				value += 50;
				break;
			case 'C':
				value += 100;
				break;
			case 'D':
				value += 500;
				break;
			case 'M':
				value += 1000;
				break;
			default: throw new NumberFormatException("Literal contains unknown digit.");
		}
		return value;
	}
	
	public static int gcd(int b, int a) {
		if (b > a) return gcd(a, b);
		
		while (b != 0) 
		{
		    int m = a % b;
		    a = b;
		    b = m;
		}
		return a;
	}
	
	
	public static boolean isAbundant(int n) {
		int sum = 0;
		for (int i = 1; i < n; i++)
			if (n % i == 0)
				if ((sum += i) > n) return true;
		
		return false;
	}

	public static boolean is1to9Pandigital(int n) {
		boolean[] digits = new boolean[9];
		int tmp;
		
		while (n != 0) {
			tmp = n % 10 - 1;
			if (tmp < 0) return false;
			else if (digits[tmp]) return false;
			else digits[tmp] = true;
			n /= 10;
		}
		
		for (boolean item : digits) if (!item) return false;
		
		return true;
	}
	
	public static boolean is0to9SemiPandigitalAndStep(long n) {
		boolean[] digits = new boolean[10];
		int last = (int)(n % 10);
		int tmp;

		while (n != 0) {
			tmp = (int)(n % 10);
			if (Math.abs(last - tmp) > 1) return false;
			digits[tmp] = true;
			n /= 10;
			last = tmp;
		}
		
		for (boolean item : digits) if (!item) return false;
		
		return true;
	}
	
	public static boolean is1to9Pandigital(int... numbers) {
		boolean[] digits = new boolean[9];
		int tmp;
		
		for (int n : numbers)
			while (n != 0) {
				tmp = n % 10 - 1;
				if (tmp < 0) return false;
				else if (digits[tmp]) return false;
				else digits[tmp] = true;
				n /= 10;
				System.out.println(Arrays.toString(digits));
			}
		
		System.out.println(Arrays.toString(digits));
		
		for (boolean item : digits) if (!item) return false;
		
		return true;
	}
	
	public static int concat(int... numbers) {
		int result = 0, position = 0;
		for (int i = numbers.length - 1; i > -1; i--)
			while (numbers[i] != 0) {
				result += (numbers[i] % 10) * Math.pow(10, position++);
				numbers[i] /= 10;
			}
		return result;
	}
	
	public static int triangle(int n) {
		return n * (n + 1) / 2;
	}
	
	public static int pentagon(int n) {
		return n * (3 * n - 1) / 2;
	}
	
	public static boolean isPentagonal(long n) {
		return ((Math.sqrt(1 + 24 * n) + 1) / 6.0) % 1.0 == 0.0;
	}
	
	public static long hexagon(long n) {
		return n * (2 * n - 1);
	}
	
	public static void floyd(String string, int index) {
		char[] array = string.toCharArray();
		int tortoise =  index + 1;
		int hare = index + 2;
		
		while (array[tortoise] != array[hare]) {
			tortoise++;
			hare += 2;
		}
		
		int mu = 0;
		
		tortoise = index;
		while (tortoise != hare) {
			
		}
	}
	
	public static String brent(String string) {
		int power = 1, lam = 1, tortoise = 0, hare = 0;
		
		while (tortoise != hare) {
			if (power == lam) {
				tortoise = hare;
				power *= 2;
				lam = 0;
			}
			hare++;
			lam += 1;
		}
		
		int mu = 0;
		tortoise = hare = 0;
		
		for (int i = 0; i < lam; i++) {
			hare = hare++;
		}
		
		while (tortoise != hare) {
			tortoise++;
			hare++;
			mu++;
		}
		
		return string.substring(tortoise, mu);
	}
	/*
	public static String brent(String string, int index) {
		int turtle = 0, rabbit = 0, taken = 0, limit = 2;
		while (true) {
			if (rabbit == string.length() - 1)
				return "";
			
			rabbit++;
			taken++;
			
			if (rabbit == turtle) {
			}
			}
		}
	}*/
	
	public static long[] blumBlumShub(int size) {
		long[] result = new long[size];
		result[0] = (290797L * 290797L) % 50515093L;
		
		for (int i = 1; i < result.length; i++)
			result[i] = (result[i - 1] * result[i - 1]) % 50515093L;
		
		return result;
	}
	
	public static class Point2D {
		public static final Point2D ORIGIN = new Point2D(0, 0);
		public final long x, y;
		
		public Point2D(long x, long y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public boolean equals(Object o) {
			if (o == this)
				return true;
			
			if (o.getClass() != this.getClass())
				return false;
			
			Point2D other = (Point2D)o;
			
			return x == other.x && y == other.y;
		}
		
		@Override
		public String toString() {
			return "[" + x + ":" + y + "]";
		}
	}
	
	public static class Line2D {
		private final Point2D a, b;
		
		public Line2D(long x0, long y0, long x1, long y1) {
			this.a = new Point2D(x0, y0);
			this.b = new Point2D(x1, y1);
		}
		
		public Line2D(final Point2D a, final Point2D b) {
			this.a = a;
			this.b = b;
		}
		
		public Point2D intersection(final Line2D other) {
			long d = (a.x - b.x) * (other.a.y - other.b.y) - (a.y - b.y) * (other.a.x - other.b.x);
			if (d == 0) return null;
			
			return new Point2D (
				((other.a.x - other.b.x) * (a.x * b.y - a.y * b.x) - (a.x - b.x) * (other.a.x * other.b.y - other.a.y * other.b.x)) / d,
				((other.a.y - other.b.y) * (a.x * b.y - a.y * b.x) - (a.y - b.y) * (other.a.x * other.b.y - other.a.y * other.b.x)) / d
			);
		}
		
		public Point2D trueIntersection(final Line2D other) {
			Point2D point = intersection(other);
			
			if (point == null)
				return null;
			
			if (point.equals(Point2D.ORIGIN))
				return null;
			
			if (point.equals(a) || point.equals(b) || point.equals(other.a) || point.equals(other.b))
				return null;
			
			return point;
		}
		
		@Override
		public boolean equals(Object o) {
			if (o == this)
				return true;
			
			if (o.getClass() != this.getClass())
				return false;
			
			Line2D other = (Line2D)o;
			
			return a == other.a && b == other.b;
		}
		
		@Override
		public String toString() {
			return "[" + a + ":" + b + "]";
		}
	}
}
