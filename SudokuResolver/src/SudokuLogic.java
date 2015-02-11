public class SudokuLogic
{

	public boolean isValid(int[][] tab, int startRow, int startColumm,
			int number)
	{
		// Regarde le carré
		int initPosX = startRow - startRow % 3;
		int initPosY = startColumm - startColumm % 3;
		for (int i = initPosX; i < initPosX + 3; i++)
		{
			for (int j = initPosY; j < initPosY + 3; j++)
			{
				if (tab[i][j] == number)
				{
					return false;
				}
			}
		}
		//Regarle la ligne et la colonne
		for (int i = 0; i < 9; i++)
		{
			//Regarde la ligne
			if (tab[i][startColumm] == number)
			{
				return false;
			}
			//Regarde la colonne
			if (tab[startRow][i] == number)
			{
				return false;
			}
		}

		return true;
	}
	public boolean isValid(int[][] tab, int startRow, int startColumm)
	{
		// Regarde le carré
		int initPosX = startRow - startRow % 3;
		int initPosY = startColumm - startColumm % 3;
		int number=tab[startRow][startColumm];
		for (int i = initPosX; i < initPosX + 3; i++)
		{
			for (int j = initPosY; j < initPosY + 3; j++)
			{
				if(i==startRow&&j==startColumm)
					continue;
				if (tab[i][j] == number)
				{
					return false;
				}
			}
		}
		//Regarle la ligne et la colonne
		for (int i = 0; i < 9; i++)
		{
			if(i==startRow)
				continue;
			if (tab[i][startColumm] == number)
			{
				return false;
			}
		}
		for (int j = 0; j < 9; j++)
		{
			//Regarde la colonne
			if(j==startColumm)
				continue;
			if (tab[startRow][j] == number)
			{
				return false;
			}
		}
		return true;
	}

	public boolean isDoable(int[][] sudoku)
	{
		for (int i = 0; i < sudoku.length; ++i)
		{
			for (int j = 0; j < sudoku[i].length; ++j)
			{
				if (sudoku[i][j] != 0)
				{
					if (!isResolvable(sudoku, i, j))
					{
						return false;
					}
				}
			}
		}
		return true;
	}
	public boolean isSudokuResolvable(int[][] sudoku)
	{
		for (int i = 0; i < sudoku.length; i++) 
			for (int j = 0; j < sudoku.length; j++) 
				if(sudoku[i][j]!=0&&!this.isValid(sudoku, i, j))
					return false;
		return true;
	}

	private boolean isResolvable(int[][] sudoku, int x, int y)
	{
		int k = sudoku[x][y];
		for (int i = 0; i < 9; ++i)
		{
			if (i != x && sudoku[i][y] == k)
			{
				return false;
			}
			if (i != y && sudoku[x][i] == k)
			{
				return false;
			}
		}
		// Check for 3x3
		int initPosX = x - x % 3;
		int initPosY = y - y % 3;
		for (int i = initPosX; i < initPosX + 3; i++)
		{
			for (int j = initPosY; i < initPosY + 3; j++)
			{
				if (sudoku[i][j] == k && i != x && j != y)
				{
					return false;
				}
			}
		}
		return true;
	}

}
