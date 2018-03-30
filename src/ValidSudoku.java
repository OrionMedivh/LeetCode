import java.util.HashSet;
import java.util.Set;

/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

 */

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {

		for (int i = 0; i < 9; i++) {
			Set<Character> row = new HashSet<>();
			Set<Character> column = new HashSet<>();
			Set<Character> box = new HashSet<>();

			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.' && !row.add(board[i][j])) {
					return false;
				}

				if (board[j][i] != '.' && !column.add(board[j][i])) {
					return false;
				}

				int[] newIndex = convertBoxToRowIndex(i, j);
				if (board[newIndex[0]][newIndex[1]] != '.' && !box.add(board[newIndex[0]][newIndex[1]])) {
					return false;
				}
			}
		}
		return true;
	}

	/*
	 * Convert box indices into row indices.
	 * i -> box id, j -> item id. 
	 * e.g. (0,2) -> (0,2), (0,3) -> (1,0), 
	 * (1,0) -> (0,3), (1,1) -> (0,4)
	 */
	private int[] convertBoxToRowIndex(int i, int j) {
		int[] result = new int[2];
		result[0] = i / 3 * 3 + j / 3;
		result[1] = i % 3 * 3 + j % 3;
		return result;
	}
}
