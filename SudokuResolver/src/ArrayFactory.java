import java.io.BufferedReader;

public class ArrayFactory
{
	public int[][] getSudokuArrayFromFile(String filePath)
	{
		int[][] sudokuArray = new int[9][9];
		
		BufferedReader reader = FileUtility.retrieveFile(filePath);
		String readChar;
		int j = 0;
		try
		{
			while((readChar = reader.readLine()) != null)
			{
				for(int i = 0 ; i < 9 ; ++i)
				{
					sudokuArray[i][j] = Character.getNumericValue(readChar.charAt(i));
				}
				j++;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sudokuArray;
	}
}
