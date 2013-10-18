package euler.problems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

class Problem96 {
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(new File("sudoku.txt"));
		}
		catch (FileNotFoundException e) {
			System.err.println("sudoku.txt not found!");
			System.exit(1);
		}
		int[][] sudoku = new int[9][9];
		int sum = 0;
		
		for (int i = 0; i < 50; i++) {
			sc.next();
			sc.next();
			for (int a = 0; a < 9; a++) {
				char[] line = sc.next().toCharArray();
				System.out.println(Arrays.toString(line));
				for (int b = 0; b < 9; b++) {
					sudoku[a][b] = Character.digit(line[b], 10);
				}
			}
			
			for (int[] line : sudoku)
				System.out.println(Arrays.toString(line));
			
			System.out.println();
			
			solve(sudoku);
			
			for (int[] line : sudoku)
				System.out.println(Arrays.toString(line));
			
			System.out.println();
			System.out.println();
			
			sum += sudoku[0][0] * 100 + sudoku[0][1] * 10 + sudoku[0][2];
		}
		System.out.println(sum);
	}
	
        public static boolean solve(int[][] sudoku)
        {
            if (sudoku[0][0] == 0)
            {
                for (int n = 1; n < 10; n++)
                    if (check(sudoku, 0, 0, n))
                    {
                        sudoku[0][0] = n;
                        if (solve(sudoku, 0, 1))
                            return true;
                    }
                sudoku[0][0] = 0;
            }
            else
                return solve(sudoku, 0, 1);

            return false;
        }

	private static boolean solve(int[][] sudoku, int y, int x)
	{
		if (x == 9)
		{
			y++;
			x = 0;
		}

		if (y == 9)
			return true;

		if (sudoku[y][x] == 0)
		{
			for (int n = 1; n < 10; n++)
				if (check(sudoku, y, x, n))
				{
					sudoku[y][x] = n;
					if (solve(sudoku, y, x + 1))
						return true;
				}
			sudoku[y][x] = 0;
		}
		else
			return solve(sudoku, y, x + 1);

		return false;
	}

	private static boolean check(int[][] sudoku, int y, int x, int n)
	{
		int i = 0;

		for (i = 0; i < 9; i++)
			if (sudoku[i][x] == n && y != i)
				return false;

		for (i = 0; i < sudoku[y].length; i++)
			if (sudoku[y][i] == n && x != i)
				return false;

		int p = y / 3 * 3, q = x / 3 * 3, j = 0;

		for (i = p; i < p + 3; i++)
			for (j = q; j < q + 3; j++)
				if (sudoku[i][j] == n && (y != i || x != j))
					return false;
		return true;
	}
}
