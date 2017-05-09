import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationII {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		permuteUnique(nums, list, 0);
		return list;
	}

	public void permuteUnique(int[] nums, List<List<Integer>> list, int index) {
		if (index == nums.length - 1) {
			ArrayList<Integer> p = new ArrayList<Integer>();
			for (int i : nums)
				p.add(i);
			list.add(p);
			return;
		}
		for (int i = index; i < nums.length; i++) {
			if (i != index && nums[i] == nums[i - 1])
				continue;
			swap(nums, i, index);
			permuteUnique(nums, list, index + 1);
			swap(nums, i, index);
		}
		// or
		// i != index && nums[i] == nums[index]
		// permuteUnique(Arrays.copyOf(nums, nums.length), list, index + 1);
		// no swap back
		// but why?
	}

	public void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

	public static void main(String[] args) {
		PermutationII s = new PermutationII();
		// int [] input = new int []{1,2,3,4};
		// System.out.print(s.permuteUnique(input));
		int[] input = new int[] { 2, 2, 1, 1 };
		System.out.print(s.permuteUnique(input));
	}
}