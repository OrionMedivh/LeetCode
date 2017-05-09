import java.util.HashSet;

//unsorted, different than sorted array

public class EraseDuplicateInAnUnsortedArray {
	public int removeDupicates(int[] nums) {
		if (nums.length <= 1) {
			return nums.length;
		}
		HashSet<Integer> set = new HashSet<>();
		int count = 0;
		for (int i : nums) {
			if (!set.contains(i)) {
				set.add(i);
				nums[count++] = i;
			}
		}
		return count;
	}
}
