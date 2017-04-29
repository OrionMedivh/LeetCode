public class WiggleSort {
//    public void wiggleSort(int[] nums) {
//        for(int i=1;i<nums.length;i++){
//            int tmp = nums[i-1];
//            if((i%2==1) == (tmp > nums[i])){
//                nums[i-1] = nums[i];
//                nums[i] = tmp;
//            }
//        }
//    }
	
    public void wiggleSort(int[] nums) {
        int sign = 1;
        for(int i =0 ;i < nums.length-1; i++)
        {
            if((nums[i] - nums[i+1])*sign > 0)
            {
                swap(nums, i, i+1);
            }
            sign *=-1;
        }
    }
    
    public void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}