
public class SudokuLogic {

	public boolean isValid (int[][] tab, int startRow, int startColumm, int number)
	{
		//Regarde le carré
		int initPosX = startRow - startRow % 3;
		int initPosY = startColumm - startColumm % 3;
	    for(int i = initPosX; i < initPosX + 3; i++) {
	    	for(int j = initPosY; i < initPosY + 3; j++) {
	    		if(tab[i][j] == number) {
	    			return false;
	    		}
	    	}
	    }
	    //Regarde la ligne
	    for(int i = 0; i < 8; i++) {
	    	if(tab[i][startColumm] == number) {
	    		return false;
	    	}
	    }
    	//Regarde la colonne
	    for(int j = 0; j < 8; j++) {
	    	if(tab[startRow][j] == number) {
	    		return false;
	    	}
	    }
	    
	    return true;
	}
	
}
