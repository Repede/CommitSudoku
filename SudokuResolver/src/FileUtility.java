import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;


public class FileUtility
{
	/**
	 * Retrieve a file from a given path.
	 * 
	 * @param pathFile
	 * @return BufferedReader
	 */
	public BufferedReader retrieveFile(String pathFile)
	{
		BufferedReader reader = null;
		try
		{
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(pathFile), Charset.forName("UTF-8")));
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		return reader;
	}
}
