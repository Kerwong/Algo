package com;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with
 * the character '.'.
 * 
 * 
 * A partially filled sudoku which is valid.
 * 
 * Note: A valid Sudoku board (partially filled) is not necessarily solvable.
 * Only the filled cells need to be validated.
 * */

public class Solution {
	public boolean isValidSudoku(char[][] board) {
		if (board == null) {
			return false;
		}
		
		char[] tmpChars = new char[9];
		boolean tmpRet = false;
		// check row
		for (int i = 0; i < 9; i++) {
			tmpRet = checkSudoku(board[i]);
			if (tmpRet == false) {
				return false;
			}
		}
		
		// check column
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				tmpChars[j] = board[j][i];
			}
			tmpRet = checkSudoku(tmpChars);
			if (tmpRet == false) {
				return false;
			}
		}
		
		// check square
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					int row = i/3;
					int col = i%3;
					tmpChars[j*3+k] = board[row*3+j][col*3+k];	// 注意此部分
				}
			}
			tmpRet = checkSudoku(tmpChars);
			if (tmpRet == false) {
				return false;
			}
		}
		
		return true;
	}
	
	private boolean checkSudoku(char[] number) {
		boolean[] temp = new boolean[9];
		
		for (int i = 0; i < number.length; i++) {
			if (number[i] == '.') {
				continue;
			}
			int index = number[i] - '1';
			if (!temp[index]) {
				temp[index] = true;				
			} else {
				return false;
			}
		}
		return true;
	}
}