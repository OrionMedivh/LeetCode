public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if(grid == null) return 0;
        int ver = grid.length;
        if(ver==0) return 0;
        int hor = grid[0].length;
        if(hor==0) return 0;
        int count=0;
        for(int i=0;i<ver;i++){
            for(int j=0;j<hor;j++){
                if(grid[i][j]=='1'){
                    count++;
                    traverse(i,j,ver,hor,grid);
                }
            }
        }
        return count;
    }
    
    public void traverse(int m, int n, int ver,int hor,char[][] grid){
        if(m<0 || m==ver) return;
        if(n<0 || n==hor) return;
        if(grid[m][n]=='1'){
        grid[m][n]='0';
        traverse(m-1,n,ver,hor,grid);
        traverse(m,n-1,ver,hor,grid);
        traverse(m+1,n,ver,hor,grid);
        traverse(m,n+1,ver,hor,grid);
        }
    }
}