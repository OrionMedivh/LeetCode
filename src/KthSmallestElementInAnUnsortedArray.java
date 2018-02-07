import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElementInAnUnsortedArray {
	public int findKthSmallest(int nums[], int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(k, Collections.reverseOrder());
		for (int i = 0; i < nums.length; i++) {
			pq.offer(nums[i]);
			if (pq.size() > k) {
				pq.poll();
			}
		}
		return pq.peek();
	}
}
