import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> list = new ArrayList<>();
    	if(matrix == null) return list;
        int m = matrix.length;
        if(m==0) return list;
        int n = matrix[0].length;
        if(n==0) return list;
        
        spiralOrder(matrix, 0, m, 0, n, 0, list);
        return list;
    }
    
    public void spiralOrder(int[][] matrix, int xstart, int xend, int ystart, int yend, int direction, List<Integer> list){
    	if(xstart == xend || ystart==yend) return;
    	switch(direction){
    	case 0: // right
    		for(int i=ystart; i< yend; i++){
    			list.add(matrix[xstart][i]);
    		}
    		spiralOrder(matrix, xstart+1, xend, ystart, yend, (direction+1)%4, list);
    		break;
    	case 1: // down
    		for(int i=xstart; i< xend; i++){
    			list.add(matrix[i][yend-1]);
    		}
    		spiralOrder(matrix, xstart, xend, ystart, yend-1, (direction+1)%4, list);
    		break;
    	case 2: // left
    		for(int i=yend-1; i>= ystart; i--){
    			list.add(matrix[xend-1][i]);
    		}
    		spiralOrder(matrix, xstart, xend-1, ystart, yend, (direction+1)%4, list);
    		break;
    	case 3: // up
    		for(int i=xend-1; i>= xstart; i--){
    			list.add(matrix[i][ystart]);
    		}
    		spiralOrder(matrix, xstart, xend, ystart+1, yend, (direction+1)%4, list);
    		break;
    	}
    }
    
    public static void main(String[] args){
    	SpiralMatrix s = new SpiralMatrix();
    	//System.out.println(s.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    	System.out.println(s.spiralOrder(new int[][]{{2,3}}));
    }
}