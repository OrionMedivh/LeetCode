import java.util.Arrays;
import java.util.Stack;


public class NextGreaterElementII {
	
    public int[] nextGreaterElements(int[] nums) {
    	//major difference from the NextGreaterElement I
    	//1. circular, solution is to search twice.
    	//2. duplicates allowed, so can't use value itself anymore,
    	//need to change to indices.
        int n = nums.length, next[] = new int[n];
        Arrays.fill(next, -1);
        Stack<Integer> stack = new Stack<>(); // index stack
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n]; 
            while (!stack.isEmpty() && nums[stack.peek()] < num)
                next[stack.pop()] = num;
            if (i < n) stack.push(i);
        }   
        return next;
    }
    
	public static void main(String[] args) {
		NextGreaterElementII s = new NextGreaterElementII();
		System.out.println(Arrays.toString(s.nextGreaterElements(new int[]{9,8,7,3,2,1,6})));

	}

}
