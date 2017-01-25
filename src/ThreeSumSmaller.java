import java.util.Arrays;

public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        int n = nums.length;
        for(int i =0; i<n-2; i++){
            int j=i+1, k=n-1; // two pointer
            while(j<k){
                if(nums[i]+nums[j]+nums[k] < target){
                    result+=k-j; // i, j, [j+1 to k]
                    j++;
                }else{
                    k--;
                }
            }
        }
        return result;
    }
}