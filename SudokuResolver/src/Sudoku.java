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
		
		this.searchNumber(new Point(0,0));
		
		System.out.println(Arrays.deepToString(grid));
	}

	private boolean searchNumber(Point point){
		// try each number until it's valid
		for(int number=1; number<10; number++){
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
}
