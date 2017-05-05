import java.util.*;

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals.size() <= 1)
			return intervals;
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				if (i1.start != i2.start) {
					return i1.start - i2.start;
				}
				return i1.end - i2.end;
			}
		});
		// Iterator<Interval> it = intervals.iterator();
		// Interval cur = it.next();
		// while (it.hasNext()) {
		// Interval next = it.next();
		// if (cur.end < next.start) {
		// cur = next;
		// continue;
		// } else {
		// cur.end = Math.max(cur.end, next.end);
		// it.remove();
		// }
		// }
		// return intervals;
		List<Interval> result = new LinkedList<Interval>();
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;

		for (Interval interval : intervals) {
			if (interval.start <= end) // Overlapping intervals, move the end if
										// needed
				end = Math.max(end, interval.end);
			else { // Disjoint intervals, add the previous one and reset bounds
				result.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}

		// Add the last interval
		result.add(new Interval(start, end));
		return result;
	}

	public List<Interval> merge2(List<Interval> intervals) {
		List<Interval> result = new ArrayList<Interval>();
		if (intervals == null || intervals.isEmpty()) {
			return intervals;
		}
		Collections.sort(intervals, (x, y) -> ((x.start - y.start) != 0 ? x.start - y.start : x.end - y.end));
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		for (Interval interval : intervals) {
			if (interval.start <= end) {
				end = Math.max(end, interval.end);
			} else {
				result.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		result.add(new Interval(start, end));
		return result;
	}
}