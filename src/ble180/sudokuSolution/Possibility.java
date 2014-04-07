package ble180.sudokuSolution;

/**
 * It represents one possible number in a position in the Sudoku game
 * 
 * @author ble180
 *
 */

public class Possibility {
	
	private int row;
	private int column;
	private int PossibleNumber;
	
	public Possibility(int row, int column, int PossibleNumber){
		this.row = row;
		this.column = column;
		this.PossibleNumber = PossibleNumber;
	}

	/**
	 * Get the row of the possibility
	 */
	public int getRow() {
		return row;
	}
	
	/**
	 * Get the column of the possibility
	 */
	public int getColumn() {
		return column;
	}
	
	/**
	 * Get the number of the possibility
	 */
	public int getPossibleNumber() {
		return PossibleNumber;
	}

}
