public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        int Ah = A.length, Al = A[0].length, Bh = B.length, Bl = B[0].length;
        int[][] c = new int[Ah][Bl];
        for(int i=0;i<Ah;i++)
        for (int p=0;p<Al;p++)
        if (A[i][p]!=0)
        for(int j=0;j<Bl;j++)
        if (B[p][j] != 0)
        c[i][j]+=(A[i][p]*B[p][j]);
        return c;
    }
    
    public static void main(String[] args){
    	SparseMatrixMultiplication s = new SparseMatrixMultiplication();
    	int[][] A = new int[][] {{1,0,0},{-1,0,3}};
    	int[][] B = new int[][] {{7,0,0},{0,0,0},{0,0,1}};
    	System.out.print(s.multiply(A, B));
    }
}