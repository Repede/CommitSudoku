
public class SudokuLogic {


	public boolean IsValide(int[][] tab,int starRow,int starColumm,int num)
	{
		//Checking box 3X3
		int initPosX=starRow-starRow%3;
		int initPosY=starColumm-starColumm%3;
	    for(int i=initPosX;i<initPosX+3;i++)
	    	for(int j=initPosY;i<initPosY+3;j++)
	    		if(tab[i][j]==num)
	    			return true;
	    for(int i=0;i<8;i++)
	    	if(tab[i][starColumm]==num)
	    		return true;
	    for(int j=0;j<8;j++)
	    	if(tab[starRow][j]==num)
	    		return true;
	    return false;
	}
	
}
