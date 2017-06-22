
/*
Given an 2D board, count how many battleships are in it. 
The battleships are represented with 'X's, empty slots are 
represented with '.'s. You may assume the following rules:

You receive a valid board, made of only battleships or empty slots.
Battleships can only be placed horizontally or vertically. In 
other words, they can only be made of the shape 1xN (1 row, 
N columns) or Nx1 (N rows, 1 column), where N can be of any size.
At least one horizontal or vertical cell separates between two 
battleships - there are no adjacent battleships.
Example:
X..X
...X
...X
In the above board there are 2 battleships.
Invalid Example:
...X
XXXX
...X
This is an invalid board that you will not receive - as battleships 
will always have a cell separating between them.
Follow up:
Could you do it in one-pass, using only O(1) extra memory and without 
modifying the value of the board?
 */

public class BattleshipsInABoard {

	// only need to count the first 'X' of a battleship.
	// which means to check if X doesn't have a left or top 'X'.
	public int countBattleships(char[][] board) {
		int m = board.length;
		if (m == 0)
			return 0;
		int n = board[0].length;

		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'X' && (i == 0 || board[i - 1][j] != 'X') && (j == 0 || board[i][j - 1] != 'X')) {
					count++;
				}
			}
		}
		return count;
	}

	// accepted, but went to complex
	// idea: battleship number = X number - connected X number/2
	public int countBattleships2(char[][] board) {
		int[] direction = new int[] { 1, 0, -1, 0, 1 };
		int x = 0, connect = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'X') {
					x++;
					for (int k = 0; k < 4; k++) {
						int newI = i + direction[k];
						int newJ = j + direction[k + 1];
						if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length
								&& board[newI][newJ] == 'X') {
							connect++;
						}
					}
				}
			}
		}
		return x - connect / 2;
	}
}
