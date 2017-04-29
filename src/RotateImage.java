public class RotateImage {
    public void rotate(int[][] matrix) {
        int column=matrix.length;
        if (column==0) return;
        for (int i=0;i<column/2;i++)
        for (int j=i;j<column-1-i;j++){
            int temp=matrix[i][j];
            matrix[i][j]=matrix[column-1-j][i];
            matrix[column-1-j][i]=matrix[column-1-i][column-1-j];
            matrix[column-1-i][column-1-j]=matrix[j][column-1-i];
            matrix[j][column-1-i]=temp;
        }
    }
}