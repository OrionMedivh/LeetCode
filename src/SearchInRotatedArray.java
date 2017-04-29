public class SearchInRotatedArray {
    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length-1);
    }
    
    public int search(int[] nums, int target, int begin, int end){
        if (begin == end){
            if (nums[begin] == target) return begin;
            return -1;
        }
        int middle = (begin + end)/2;
        if (nums[begin]<= nums[middle]){ // this end is sorted.
            if (nums[middle] >= target && nums[begin] <= target)
            return search(nums, target, begin, middle);
            else 
            return search(nums, target, middle+1, end);
        }else{ // means the other side is sorted.
            if (nums[middle] < target && nums[end] >= target)
            return search(nums, target, middle+1, end);
            else
            return search(nums, target, begin, middle);
        }
    }
}