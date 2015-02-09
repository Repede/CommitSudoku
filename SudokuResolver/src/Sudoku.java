
public class Sudoku
{
	public static void main(String[] args)
	{
		// TODO SUICIDE BY SUDOKU
		Sudoku sudoku = new Sudoku();
		//sudoku.resolve();
	}
	
//	public void resolve(){
//		// Retrieve the sudoku grid.
//		ArrayFactory fact = new ArrayFactory();
//		this.grid = fact.getSudokuArrayFromFile("sudoku1.sud");
//	}
//
//	private boolean backTrack(int row, int column){
//		//try each number until it's valid
//		for(int number=0; number<9; number++){
//			if(isValid(this.grid, row, column, number)){
//				
//				this.grid[row][column] = number;
//				int nextRow = this.retrieveNextRow();
//				int nextColumn = this.retriveNextColumn(row);
//				
//				if(backTrack(nextRow, nextColumn)){
//					return true;
//				}
//				
//				this.grid[row][column] = 0;
//			}
//		}
//		
//		return false;
//	}
}
