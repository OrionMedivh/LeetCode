import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
	public int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}

	public int findKthLargest2(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int num : nums) {
			pq.offer(num);

			if (pq.size() > k) {
				pq.poll();
			}
		}
		return pq.peek();
	}

	public int findKthLargest3(int nums, int k) {
		// quick select
		return 0;
	}
}
