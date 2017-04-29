import java.util.HashMap;


public class MaximumSizeSubarraySumEqualsK {
	public int maxSubArrayLen(int[] nums, int k) {
	    int sum = 0, max = 0;
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < nums.length; i++) {
	        sum = sum + nums[i];
	        if (sum == k) max = i + 1;
	        else if (map.containsKey(sum - k))
	        	max = Math.max(max, i - map.get(sum - k)); //subarray [i, j] = subarray[0, j] - subarray[0,i]
	        if (!map.containsKey(sum)) map.put(sum, i);
	    }
	    return max;
	}
	
	public static void main(String[] args){
		MaximumSizeSubarraySumEqualsK s = new MaximumSizeSubarraySumEqualsK();
//		System.out.println(s.maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3));
		System.out.println(s.maxSubArrayLen(new int[]{-2, -1, 2, 1}, 1));
	}
}
