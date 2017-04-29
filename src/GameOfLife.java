import java.util.Arrays;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
    	int hor = board.length;
    	int ver = board[0].length;
        int[][] result = new int[hor][ver];
        for(int i = 0;i<hor;i++)
        	for(int j = 0;j<ver;j++){
            	int count=0;
            	for(int p = i-1; p<i+2;p++)
            		for(int q = j-1; q<j+2; q++){
            			if(p>=0 && p < hor && q>=0 && q<ver && !(p==i && q==j) && board[p][q]==1) count++;
            		}
            	if(count < 2) result[i][j]=0;
            	else if(count > 3) result[i][j]=0;
            	else if(count == 3) result[i][j]=1;
            	else result[i][j]=board[i][j];
        	}
        for(int i = 0;i<hor;i++)
        	for(int j = 0;j<ver;j++){
        		board[i][j] = result[i][j];
        	}
    }
    
    public static void main(String[] args){
    	GameOfLife s = new GameOfLife();
//    	int sys[][] = new int[][]{{0,0,0,0},{0,1,1,0},{0,1,1,0},{0,0,0,0}};
    	int sys[][] = new int[][]{{1,1},{1,0}};
    	s.gameOfLife(sys);
    	for(int[] a:sys)
    	System.out.println(Arrays.toString(a));
    }
}