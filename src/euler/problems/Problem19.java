package euler.problems;

import java.util.Calendar;

public class Problem19 {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		int count = 0;
		for (int year = 1901; year < 2001; year++) {
			for (int month = 1; month < 13; month++) {
				cal.set(year, month, 1);
				
				if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
					count++;
			}
		}
		System.out.println(count);
	}
}