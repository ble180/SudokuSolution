package ble180.sudokuSolution;

import java.util.ArrayList;

/**
 * 
 * @author ble180
 *
 */
public class SudokuSolution {

	public static void main(String[] args) {

		int[][] s = { { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
				{ 6, 0, 0, 1, 9, 5, 0, 0, 0 }, { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
				{ 8, 0, 0, 0, 6, 0, 0, 0, 3 }, { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
				{ 7, 0, 0, 0, 2, 0, 0, 0, 6 }, { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
				{ 0, 0, 0, 4, 1, 9, 0, 0, 5 }, { 0, 0, 0, 0, 8, 0, 0, 7, 9 } };

		Sudoku sudoku = new Sudoku(s);

		solve(0, 0, sudoku);
	}

	public static void solve(int row, int col, Sudoku sudoku) {

		// If the row is 9 the algorithm has finished
		if (row == 9) {
			return;
		}

		// If there is a number in the position (row, col) we test with the next
		if (sudoku.getNumber(row, col) != 0) {
			solve(col == 8 ? row + 1 : row, (col + 1) % 9, sudoku);
		} else {

			// Get the possibilites for the position (row, col)
			ArrayList<Possibility> posibilidades = sudoku.getPossibilities(row, col);

			for (Possibility siguientePos : posibilidades) {
				
				// Get the number that it is possible to put
				int num = siguientePos.getPossibleNumber();

				// Set the number in the position
				sudoku.setNumber(row, col, num);

				if (sudoku.isFinish()) {
					System.out.println("ONE SOLUTION IS:\n");
					sudoku.printSudoku();
					return;
				} else {
					solve(col == 8 ? row + 1 : row, (col + 1) % 9, sudoku);
				}

				// Remove the number in the position to try another possibility
				sudoku.removeNumber(row, col);
			}
		}
	}
}
