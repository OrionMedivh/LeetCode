
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
    	
    	if(nums ==null) return true;
    	
    	//find sum/2
    	int total = 0;
    	for(int num:nums){
    		total += num;
    	}
    	
    	if(total %2 != 0){
    		return false;
    	}
    	
    	return subsetMatching(nums, total/2);
    }
    
    boolean subsetMatching(int[] nums, int target){
    	boolean[] dp = new boolean[target+1];
    	dp[0] = true; // 0 is always true
    	for(int i=1; i <= nums.length; i++){
    		for( int j = target; j>= nums[i-1]; j-- ){
    		  //it's a compress of 2d array from subsetMatching1, 
    		  //needs from higher index to lower is to avoid previous modification
    			int k = nums[i-1];
    			dp[j] = dp[j] || dp[j-k];
    		}
    	}
    	return dp[target];
    }
  
    boolean subsetMatching1(int[] nums, int target){
    boolean[][] dp = new boolean[nums.length][target + 1];
    // deal with the first row
    if(nums[0] <= target) dp[0][nums[0]] = true;
    
    // deal with the first col
    for(int i = 0; i < nums.length; i++) dp[i][0] = true;
    
    // deal with the rest
    for(int i = 1; i < dp.length; i++) {
        for(int j = 1; j < dp[0].length; j++) {
            if(j < nums[i]) {
                dp[i][j] = dp[i - 1][j];
            } else {
                dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]]; 
                // if previously 0-i can form j, or o-i can form j-nums[i],current number
            }
        }
    }
    return dp[dp.length - 1][dp[0].length - 1];
    }
    
    public static void main(String[] args){
    	PartitionEqualSubsetSum s = new PartitionEqualSubsetSum();
    	System.out.println(s.subsetMatching1(new int[]{1,5,5}, 6));
    }
}
