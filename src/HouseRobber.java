public class HouseRobber {
    public int rob(int[] nums) {
        if(nums == null) return 0;
        int n = nums.length;
        if(n == 0) return 0;
        int prevYes = nums[0];
        int prevNo = 0;
        for(int i=1;i<n;i++){
            int tmp = prevYes;
            prevYes = prevNo + nums[i];
            prevNo = Math.max(tmp, prevNo);
        }
        return Math.max(prevYes,prevNo);
    }
}