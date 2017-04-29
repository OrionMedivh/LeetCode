public class Search2DMatrix {
//    public boolean searchMatrix(int[][] matrix, int target) {
//        int m=matrix.length;
//        int n=matrix[0].length;
//        if (target<matrix[0][0]) return false;
//        boolean found=false;
//        for (int i=0;i<m;i++) {
//        found=found||search(matrix[i],0,n-1,target);
//        }
//        return found;
//    }
//    
//    public boolean search(int[] matrix,int start, int end, int target){
//        if (start==end) {
//        if (target==matrix[start]) return true;
//        return false;
//        } 
//
//        if (target>=matrix[start] && target<=matrix[end]){
//            return search(matrix, start, (start+end)/2, target) || 
//            search (matrix,(start+end)/2+1,end,target);
//        }
//        return false;
//    } // not good.
	
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        if (m==0) return false;
        int n=matrix[0].length;
        if (n==0) return false;
        
        if (target<matrix[0][0] || target > matrix[m-1][n-1])
        return false;
        
        int column=binarySearchColumn(0,m-1,matrix,target);
        return binarySearchRow(0,n-1,matrix,column,target);
    } 
    
    public static int binarySearchColumn(int begin, int end,int[][] matrix,int target){
        if (begin>=end) return end;
        int middle=(begin+end)/2;
        if (target==matrix[middle+1][0]) return middle+1;
        if (target>matrix[middle+1][0]) return binarySearchColumn(middle+1,end,matrix,target);
        return binarySearchColumn(begin,middle,matrix,target);
    }
    
    public static boolean binarySearchRow(int begin,int end,int[][] matrix,int column,int target){
        if (begin==end) {
            if (target==matrix[column][begin]) return true;
            return false;
        }
        int middle=(begin+end)/2;
        if (target==matrix[column][middle]) return true;
        if (target>matrix[column][middle]) return binarySearchRow(middle+1,end,matrix,column,target);
        else return binarySearchRow(begin,middle,matrix,column,target);
    }
    
    public static void main(String[] args){
    	System.out.println(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}},3));
    }
}