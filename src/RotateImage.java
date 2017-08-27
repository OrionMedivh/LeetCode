
/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
 */

/*
clockwise rotate
first reverse up to down, then swap the symmetry
1 2 3     7 8 9     7 4 1
4 5 6  => 4 5 6  => 8 5 2
7 8 9     1 2 3     9 6 3
*/

/*
anticlockwise rotate
first reverse left to right, then swap the symmetry
1 2 3     3 2 1     3 6 9
4 5 6  => 6 5 4  => 2 5 8
7 8 9     9 8 7     1 4 7
*/

/*
Naive approach:
Dive the image into four parts:

\1  2  3  4 /5
  \        /
 6 \7  8 /9  A
     +---+
 B  C| D |E  F
     +---+
 G  H/ I  J\ K
   /        \ 
 L/ M  N  O  P\

i: [0, n/2)  // need only go through (less than) half of the rows.
j: [i, n-1-i)  // each line shrink on BOTH ends. 
swap (i, j), (j, n-1-i), (n-1-i, n-1-j), (n-1-j, i) 
 */

public class RotateImage {

	public void rotateClockwise(int[][] matrix) {
		for (int i = 0; i < matrix.length / 2; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				swap(matrix, i, j, matrix.length - 1 - i, j);
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix[0].length; j++) {
				swap(matrix, i, j, j, i);
			}
		}
	}

	private void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
		int temp = matrix[i1][j1];
		matrix[i1][j1] = matrix[i2][j2];
		matrix[i2][j2] = temp;
	}

	// -------------------------------------------------------------------------------

	public void rotateAntiClockwise(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length / 2; j++) {
				swap(matrix, i, j, i, matrix.length - 1 - j);
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix[0].length; j++) {
				swap(matrix, i, j, j, i);
			}
		}
	}

	// --------------------------------------------------------------------------------

	public void rotateNaive(int[][] matrix) {
		int column = matrix.length;
		if (column == 0)
			return;
		for (int i = 0; i < column / 2; i++) {
			for (int j = i; j < column - 1 - i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[column - 1 - j][i];
				matrix[column - 1 - j][i] = matrix[column - 1 - i][column - 1 - j];
				matrix[column - 1 - i][column - 1 - j] = matrix[j][column - 1 - i];
				matrix[j][column - 1 - i] = temp;
			}
		}
	}
}