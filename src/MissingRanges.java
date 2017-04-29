import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
//    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
//        ArrayList<String> result = new ArrayList<String>();
//        int n = nums.length;
//        lower--;
//        for(int i=0;i<n;i++){
//            if(nums[i] < lower+2) {
//                lower = nums[i];
//                continue;
//            }
//            if(nums[i] > upper) 
//            	break;
//            if(nums[i] == lower+2) 
//            	result.add(nums[i]-1+"");
//            else 
//            	result.add((lower+1)+"->"+(nums[i]-1));
//            lower = nums[i];
//        }
//        if(lower == upper-1) result.add(upper+"");
//        else if (lower < upper-1) result.add((lower+1)+"->"+(upper));
//        return result;
//    }
	
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        ArrayList<String> result = new ArrayList<String>();
        int n = nums.length;
        lower--;
        for(int i=0;i<=n;i++){
        	int after = i==n? upper+1: nums[i];
            if(after == lower+2) 
            	result.add(after-1+"");
            else if(after > lower+2)
            	result.add((lower+1)+"->"+(after-1));
            lower = after;
        }
        return result;
    }
    
    public static void main(String[] args){
    	MissingRanges s = new MissingRanges();
    	System.out.println(s.findMissingRanges(new int[]{-1}, -2, -1));
    }
}