import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums == null) return;
        int n= nums.length;
        if(n==1) return;
        int i=n-1;
        while(i>=1 && nums[i-1]>=nums[i]){ //find last trunk that is ascending order
        	i--;
        }
        if(i>=1) { 
        	int j=n-1;
        	while(nums[j]<=nums[i-1]) j--; //find the index will give minimum increase.
        	swap(nums, i-1, j);
        }
        Arrays.sort(nums,i,n); //reverse sorting would save some time
    }
    
    public void swap(int[] nums, int i, int j){
    	int tmp = nums[i];
    	nums[i]= nums[j];
    	nums[j]=tmp;
    }
}