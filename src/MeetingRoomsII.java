import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {
	// public int minMeetingRooms(Interval[] intervals) {
	// if (intervals == null || intervals.length == 0)
	// return 0;
	// Arrays.sort(intervals, new Comparator<Interval>() {
	// @Override
	// public int compare(Interval i1, Interval i2) {
	// return i1.start - i2.start;
	// }
	// });
	// PriorityQueue<Interval> queue = new
	// PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
	// @Override
	// public int compare(Interval i1, Interval i2) {
	// return i1.end - i2.end;
	// }
	// });
	// queue.add(intervals[0]);
	// for (int i = 1; i < intervals.length; i++) {
	// Interval it = queue.poll();
	// if (intervals[i].start >= it.end) {
	// it.end = intervals[i].end;
	// } else {
	// queue.add(intervals[i]);
	// }
	// queue.add(it);
	// }
	// return queue.size();
	// } //java 1.7 or below

	public int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}
		Arrays.sort(intervals, (x, y) -> (x.start - y.start));
		PriorityQueue<Interval> queue = new PriorityQueue<Interval>(intervals.length, (x, y) -> (x.end - y.end));
		queue.add(intervals[0]);
		for (int i = 1; i < intervals.length; i++) {
			Interval it = queue.poll();
			if (intervals[i].start >= it.end) {
				it.end = intervals[i].end;
			} else {
				queue.offer(intervals[i]);
			}
			queue.offer(it);
		}
		return queue.size();
	} // java 8 or above
}