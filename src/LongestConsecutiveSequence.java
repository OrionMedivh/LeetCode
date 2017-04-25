import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
    	if(num == null){
    		return 0;
    	}
    	HashSet<Integer> set = new HashSet<Integer>();
    	for(int i:num){
    		set.add(i);
    	}
    	int max = 0;
    	for(int i:num){
    		int count = 1, up = i + 1, down = i - 1;
    		set.remove(i);
    		while(set.contains(up)){
    			count++;
    			set.remove(up);
    			up++;
    		}
    		while(set.contains(down)){
    			count++;
    			set.remove(down);
    			down--;
    		}
    		max = Math.max(max, count);
    	}
    	return max;
    }
}
