public class MaximumSubarray {
    public int maxSubArray(int[] A) {
        if (A.length==0) return 0;
        int curMax=A[0],Max=A[0];
        for(int i=1;i<A.length;i++){
            curMax=Math.max(curMax+A[i],A[i]);//calculate max sub array ending at index i;
            Max=Math.max(Max,curMax);//comparing each sub array to find the maximum result.
        }
        return Max;
    }
    
    public static void main(String args[]){
    	MaximumSubarray s = new MaximumSubarray();
    	int[] input= new int[]{-2,1,-3,4,-1,2,1,-5,4};
    	System.out.println(s.maxSubArray(input));
    }
}