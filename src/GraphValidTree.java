import java.util.Arrays;

public class GraphValidTree {
	public boolean validTree(int n, int[][] edges) {
		int[] nums = new int[n];
		Arrays.fill(nums, -1);
		for (int[] edge : edges) {
			int x = find(nums, edge[0]);
			int y = find(nums, edge[1]);
			if (x == y)
				return false;
			nums[x] = y; // union
		}
		return edges.length == n - 1;
	}

	private int find(int[] nums, int i) {
		if (nums[i] == -1) {
			return i;
		}
		return find(nums, nums[i]);
	}// union find, could improve by checking if there's only one -1 exist. by
		// changing the condition to nums[i] == -1 or i. return -1 or i.
}
