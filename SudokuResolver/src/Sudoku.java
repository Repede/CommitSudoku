import java.awt.Point;
import java.util.Arrays;

public class Sudoku
{
	private SudokuLogic sudokuLogic;
	private int[][] grid;
	public static void main(String[] args)
	{
		Sudoku sudoku = new Sudoku();
		sudoku.resolve();
	}
	
	public Sudoku(){
		this.sudokuLogic = new SudokuLogic(); 
		this.grid = new int[9][9];
	}
	
	public void resolve(){
		// Retrieve the sudoku grid.
		ArrayFactory fact = new ArrayFactory();
		this.grid = fact.getSudokuArrayFromFile("sudoku1.sud");
		StringBuilder str_=new StringBuilder();
		str_.append("Sudoku a resourdre:");
		printnSudoku(str_);
		
		//Checking if its resolvable
	    if(this.sudokuLogic.isSudokuResolvable(this.grid))
	    {
	    	//this.searchNumber(new Point(0,0));
			//Resolve and calculate time.
			Point pt=this.findNextAvaible();
			long start = System.currentTimeMillis();    
			this.solveWithBacktrack(pt);
			long elapsedTime = System.currentTimeMillis() - start;
		    
			//Prints outputs.
		    StringBuilder str=new StringBuilder();
		    str.append("\nTemps ecoule pour resourdre ").append(elapsedTime).append(" ms");
		    printnSudoku(str);
	    }
	    else
	    {
	    	System.out.println("\nImpossible à resourdre");
	    }
	
		
	}
	private boolean searchNumber(Point point){
		// try each number until it's valid
		for(int number=0; number<9; number++){
			if(this.sudokuLogic.isValid(this.grid, point.y, point.x, number)){
				
				this.grid[point.x][point.y] = number;
				Point nextPoint = this.retrieveNextAvailable(point);
				
				if(searchNumber(nextPoint)){
					return true;
				}				
				this.grid[point.x][point.y] = 0;
			}
		}	
		return false;
	}
	
	/*
	 * Retrieve the next available index point.
	 */
	private Point retrieveNextAvailable(Point point) {
		boolean searching = true;
		
		while(searching){
			if(point.y < 8){
				++point.y;
			}
			else if(point.y == 8){
				++point.x;
				point.y = 0;
			}
			
			if(point.x > 8){
				point.x = 0;
			}
			
			int newValue = this.grid[point.x][point.y];
			if(newValue > 0){
				searching = false;
			}			
		}		
		return point;
	}
	private boolean isSudokuSolved()
	{
		 for (int i = 0; i < grid.length; i++) 
			 for (int j = 0; j < grid.length; j++) 
				 	if(grid[i][j]==0)
				 		return false;
		 return true;	
	}
	private boolean solveWithBacktrack(Point position)
	{
		if(position==null)
			return true;
		for (int i = 0; i < grid.length; i++) 
		{
			if(this.sudokuLogic.isValid(this.grid, position.x, position.y, i+1))
			{
				this.grid[position.x][position.y]=i+1;
				if(this.solveWithBacktrack(this.findNextAvaible()))
						return true;
			}
				
		}
		this.grid[position.x][position.y]=0;
		return false;
	}
	private Point findNextAvaible()
	{
		Point pt;
		for (int i = 0; i < grid.length; i++) 
			 for (int j = 0; j < grid.length; j++) 
				 	if(grid[i][j]==0)
				 	{
						return pt=new Point(i,j);
				 	}				 	
		 return null; //you win.
	}
	private void printnSudoku(StringBuilder str)
	{
		for (int i = 0; i < grid.length; i++) 
		{
			str.append("\n");
			if((i)%3==0)
			{			
				for (int k = 0; k < 11; k++) 
					str.append("- ");
				str.append("\n");
			}
			for (int j = 0; j < grid.length; j++) {
				str.append(grid[i][j]);
				str.append(" ");				
				if((j+1)%3==0)
					str.append("|");
			}
		}
		System.out.println(str.toString());
	}
	/*
	 * function backtrack(position){
    if (isEndOfGrid == true){ // Empty cells filled. Solution found. Abort
        return true;
    }
 
    foreach (x from 1 ... 9){
        grid[position] = x;
        if (gridIsValid == true){ // Check for collisions
            if (backtrack(nextPosition) == true){ // Move to next empty cell
                return true; // Empty cells filled. Solution found. Abort.
            }
        }
    }
    grid[position] = NULL; // Empties cell
    return false; //Solution not found. Backtrack.
}
	 * */
}
