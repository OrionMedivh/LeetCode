public class LongestIncreasingPathInAMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null) return 0;
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;
        if(n == 0) return 0;
        int[][] map = new int[m][n];
        int max=0;
        for(int i = 0;i < m;i++){
            for (int j = 0;j< n;j++){
                if(map[i][j]==0){
                    traverse(i,j,m,n,map,matrix);
                    max = Math.max(max, map[i][j]);
                }
            }
        }
        return max;
    }
    
    public void traverse(int i, int j, int m, int n, int[][] map, int[][] matrix){
        if(map[i][j]!= 0){
            return;
        }
        if(i>0 && matrix[i-1][j]> matrix[i][j]){
            traverse(i-1, j, m, n,map, matrix);
            map[i][j] = Math.max(map[i-1][j]+1,map[i][j]);
        }
        if(i<m-1 && matrix[i+1][j] > matrix[i][j]){
            traverse(i+1,j,m,n,map,matrix);
            map[i][j] = Math.max(map[i+1][j]+1,map[i][j]);
        }
        if(j>0 && matrix[i][j-1] > matrix[i][j]){
            traverse(i,j-1,m,n,map,matrix);
            map[i][j] = Math.max(map[i][j-1]+1,map[i][j]);
        }
        if(j<n-1 && matrix[i][j+1] > matrix[i][j]){
            traverse(i,j+1,m,n,map,matrix);
            map[i][j] = Math.max(map[i][j+1]+1,map[i][j]);
        }
        if(map[i][j] == 0){
            map[i][j] = 1;
        }
    }
    
    
    public static void main(String[] args){
    	LongestIncreasingPathInAMatrix s = new LongestIncreasingPathInAMatrix();
    	System.out.println(s.longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}}));
    }
}