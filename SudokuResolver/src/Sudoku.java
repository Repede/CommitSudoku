
public class Sudoku
{

	public static void main(String[] args)
	{
		// TODO SUICIDE BY SUDOKU
		ArrayFactory fact = new ArrayFactory();
		fact.getSudokuArrayFromFile("sudoku1.sud");
	}
	
	public boolean isDoable(int[][] sudoku)
	{
		for(int i = 0 ; i < sudoku.length ; ++i)
		{
			for(int j = 0 ; j < sudoku[i].length ; ++j)
			{
				if(sudoku[i][j] != 0)
				{
					if(!isResolvable(sudoku,i,j))
					{
						return false;
					}
				}
			}
		}
		return true;
	}
	
	private boolean isResolvable(int[][] sudoku, int x, int y)
	{
		int k = sudoku[x][y];
		for(int i = 0 ; i < 9 ; ++i)
		{
			if(i != x && sudoku[i][y] == k)
			{
				return false;
			}
			if(i != y && sudoku[x][i] == k)
			{
				return false;
			}
		}
		//Check for 3x3
		int initPosX=x-x%3;
		int initPosY=y-y%3;
	    for(int i=initPosX;i<initPosX+3;i++)
	    {
	    	for(int j=initPosY;i<initPosY+3;j++)
	    	{
	    		if(sudoku[i][j]==k && i != x && j != y)
	    		{
	    			return false;
	    		}
	    	}
	    }
		return true;
	}
}
