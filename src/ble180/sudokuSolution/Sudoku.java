package ble180.sudokuSolution;

import java.util.ArrayList;

public class Sudoku implements Cloneable {

	private final int sizeSudoku = 9;
	private int[][] sudoku = new int[sizeSudoku][sizeSudoku];

	public Sudoku(int[][] sudoku) {
		this.sudoku = sudoku;
	}

	/**
	 * Obtain the number in the position (row, col)
	 */
	public int getNumber(int row, int col) {
		return sudoku[row][col];
	}

	/**
	 * Set the number desired in the position (row, col)
	 */
	public void setNumber(int row, int col, int number) {
		sudoku[row][col] = number;
	}

	/**
	 * Print the sudoku
	 */
	public void printSudoku() {
		for (int i = 0; i < sizeSudoku; i++) {
			for (int j = 0; j < sizeSudoku; j++) {
				System.out.print(sudoku[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("\n");
	}

	/**
	 * Return true if it is possible set the number in the row
	 */
	public boolean isPossibleNumInRow(int num, int row, int col) {
		for (int i = 0; i < sizeSudoku; i++) {
			if (sudoku[row][i] == num) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Return true if it is possible set the number in the column
	 */
	public boolean isPossibleNumInCol(int num, int row, int col) {
		for (int i = 0; i < sizeSudoku; i++) {
			if (sudoku[i][col] == num) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Return true if it is possible set the number in quadrant of the row and
	 * the column
	 */
	public boolean isPossibleNumInQuadrant(int num, int row, int col) {
		int startRow = row / 3 * 3;
		int startCol = col / 3 * 3;

		for (int i = startRow; i < startRow + 3; i++) {
			for (int j = startCol; j < startCol + 3; j++) {
				if (sudoku[i][j] == num) {
					return false;
				}
			}

		}
		return true;
	}

	/**
	 * Remove the number in the position (row, col)
	 */
	public void removeNumber(int row, int col) {
		sudoku[row][col] = 0;
	}

	/**
	 * Obtain the possibilities of put a number in the position (row, col)
	 */
	public ArrayList<Possibility> getPossibilities(int row, int col) {
		ArrayList<Possibility> p = new ArrayList<Possibility>();

		for (int num = 1; num <= 9; num++) {
			if (isPossibleNumInCol(num, row, col)
					&& isPossibleNumInRow(num, row, col)
					&& isPossibleNumInQuadrant(num, row, col)) {
				p.add(new Possibility(row, col, num));
			}
		}

		return p;
	}

	/**
	 * Return true if it has finished
	 */
	public boolean isFinish() {
		for (int i = 0; i < sizeSudoku; i++) {
			for (int j = 0; j < sizeSudoku; j++) {
				if (sudoku[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Clone the Sudoku
	 */
	@Override
	public Sudoku clone() {
		int[][] temp = new int[sizeSudoku][sizeSudoku];
		for (int i = 0; i < sizeSudoku; i++) {
			for (int j = 0; j < sizeSudoku; j++) {
				temp[i][j] = this.sudoku[i][j];
			}
		}
		return new Sudoku(temp);
	}

}
