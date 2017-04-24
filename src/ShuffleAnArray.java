import java.util.Random;

public class ShuffleAnArray {
	private int[] nums;
	private int[] clone;
	Random random; //global
	
	
    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
        this.clone = nums.clone();
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if(nums == null) return null;
        //Knuth algorithm, similar to reservoir sampling
        for(int i=1; i < clone.length; i++){ // 0 is not needed, swap with itself.
        	int j = random.nextInt(i+1); // [0 , i+1) = [0, i]; 
        	swap(clone, i, j);
        }
        return clone;
    }
    
    private void swap(int[] num, int i, int j){
    	int temp = num[i];
    	num[i] = num[j];
    	num[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
