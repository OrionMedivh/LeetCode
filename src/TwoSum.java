import java.util.HashMap;

public class TwoSum {
	public int[] twoSum(int[] numbers, int target){
		HashMap<Integer, Integer> map = new HashMap<>();
		int n = numbers.length;
		for( int i=0; i < n; i++){
			if(map.containsKey(target - numbers[i])){
				int index = map.get(target - numbers[i]);
				return new int[]{i, index};
			}
			map.put(numbers[i], i);
		}
		return new int[]{-1, -1};
	}
}