import java.util.*;

public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	ArrayList<Integer> current = new ArrayList<Integer>();
        getFactors(n, current, result, 2);
        return result;
    }
    
    private void getFactors(int n, ArrayList<Integer> current, List<List<Integer>> result, int small){
    	if (n <= 1) return;
    	for (int i=small;i<=Math.sqrt(n);i++){
    		if (n%i==0){
    			ArrayList<Integer> sub = new ArrayList<Integer>(current);
    			ArrayList<Integer> sub1 = new ArrayList<Integer>(current);
    			sub.add(i);
    			sub1.add(i);
    			sub1.add(n/i);
    			result.add(sub1);
    			getFactors(n/i, sub, result, i);
    		}
    	}
    }
}