
public class ProductOfArrayExceptSelf {
	// public int[] productExceptSelf(int[] nums) {
	// int len = nums.length;
	// int[] tmp = new int[len];
	// tmp[0]=1;
	// for(int i =1; i < len; i++){
	// tmp[i] = tmp[i-1]*nums[i-1];
	// }
	// int m =1;
	// for(int i = len-1;i>=0;i--){
	// tmp[i] *= m;
	// m *= nums[i];
	// }
	// return tmp;
	// }

	public int[] productExceptSelf(int[] nums) {
		if (nums == null || nums.length == 0) {
			return nums;
		}
		int[] res = new int[nums.length];
		res[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			res[i] = res[i - 1] * nums[i - 1];
		}
		int right = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			right *= nums[i + 1];
			res[i] *= right;
		}
		return res;
	}
}
