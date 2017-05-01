import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
	private Queue<Long> small, large;

	/** initialize your data structure here. */
	public MedianFinder() {
		small = new PriorityQueue<>();
		large = new PriorityQueue<>(Collections.reverseOrder());
	}

	public void addNum(int num) {
		small.offer((long) num);
		large.offer(small.poll());
		if (large.size() > small.size()) {
			small.offer(large.poll());
		} // keep small size >= large size
	}

	public double findMedian() {
		if (small.size() == large.size()) {
			return (small.peek() + large.peek()) / 2.0;
		}
		return small.peek();
	}
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder(); obj.addNum(num); double param_2 =
 * obj.findMedian();
 */