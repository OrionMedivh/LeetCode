
public class BurstBallons {
//	public int maxCoins(int[] iNums) {
//		int[] nums = new int[iNums.length+2];
//		int n=1;
//		for (int x:iNums) if(x>0) nums[n++]=x;
//		nums[0]=nums[n++]=1;
//		
//		int[][] memo = new int[n][n];
//		
//		return burst(memo, nums, 0, n-1);
//	}
//
//	private int burst(int[][] memo, int[] nums, int left, int right) { // return maximum bust num from left to right;
//		if(left + 1 == right) return 0;
//		if(memo[left][right] > 0) return memo[left][right];
//		for(int i =left+1 ; i<right;i++){
//			memo[left][right] = Math.max(memo[left][right], nums[left]*nums[i]*nums[right]+
//					burst(memo, nums, left, i) + burst(memo, nums, i, right));
//		}
//		return memo[left][right];
//	} // divide and conquer
	
	public int maxCoins(int[] iNums) {
		int[] nums = new int[iNums.length+2];
		int n=1;
		for (int x:iNums) if(x>0) nums[n++]=x;
		nums[0]=nums[n++]=1;
		
		int[][] memo = new int[n][n];
		for(int i=2; i < n;i++){ // distance between left and right
			for(int left=0;left< n-i; left++){
				int right = left+i;
				for(int k = left+1; k< right; k++){
					memo[left][right] = Math.max(memo[left][right], 
							nums[left]*nums[right]*nums[k]+ memo[left][k] + memo[k][right]);
				}
			}
		}
		return memo[0][n-1];
	} // DP
	
	public static void main(String[] args){
		BurstBallons s = new BurstBallons();
		System.out.println(s.maxCoins(new int[]{3,1,5,8}));
	}
}
