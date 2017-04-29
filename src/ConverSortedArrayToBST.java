
public class ConverSortedArrayToBST {
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0)
			return null;
		return sortedArrayToBST(nums, 0, nums.length - 1);
	}

	public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
		if (start > end)
			return null;
		if (start == end)
			return new TreeNode(nums[start]);
		int middle = (start + end) / 2;
		TreeNode result = new TreeNode(nums[middle]);
		result.left = sortedArrayToBST(nums, start, middle - 1);
		result.right = sortedArrayToBST(nums, middle + 1, end);
		return result;
	}
}
