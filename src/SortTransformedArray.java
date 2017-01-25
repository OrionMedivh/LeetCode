public class SortTransformedArray {
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
	    int[] res = new int[nums.length];
	    int start = 0;
	    int end = nums.length - 1; // two pointers, will converge towards peak;
	    int i = a >= 0 ? nums.length - 1 : 0;
	    while(start <= end) {
	        int startNum = getNum(nums[start], a, b, c);
	        int endNum = getNum(nums[end], a, b, c);
	        if(a >= 0) {
	            if(startNum >= endNum) {
	                res[i--] = startNum;
	                start++;
	            }
	            else{
	                res[i--] = endNum;
	                end--;
	            }
	        }
	        else{
	            if(startNum <= endNum) {
	                res[i++] = startNum;
	                start++;
	            }
	            else{
	                res[i++] = endNum;
	                end--;
	            }
	        }
	    }
	    return res;
	}
	public int getNum(int x, int a, int b, int c) {
	    return a * x * x + b * x + c;
	}
}