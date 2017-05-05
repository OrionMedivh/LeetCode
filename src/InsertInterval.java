import java.util.*;

public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		// intervals.add(newInterval);
		// if (intervals.size() <= 1) return intervals;
		// Collections.sort(intervals, new Comparator<Interval>(){
		// @Override
		// public int compare(Interval i1, Interval i2){
		// if (i1.start != i2.start) {
		// return i1.start - i2.start;
		// }
		// return i1.end - i2.end;
		// }
		// });
		// List<Interval> result = new LinkedList<Interval>();
		// int start = intervals.get(0).start;
		// int end = intervals.get(0).end;
		//
		// for (Interval interval : intervals) {
		// if (interval.start <= end) // Overlapping intervals, move the end if
		// needed
		// end = Math.max(end, interval.end);
		// else { // Disjoint intervals, add the previous one and reset bounds
		// result.add(new Interval(start, end));
		// start = interval.start;
		// end = interval.end;
		// }
		// }
		//
		// // Add the last interval
		// result.add(new Interval(start, end));
		// return result;
		int i = 0;
		while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
			i++;
		}
		while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
			newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start),
					Math.max(intervals.get(i).end, newInterval.end));
			intervals.remove(i);
		}

		intervals.add(i, newInterval);
		return intervals;
	}

	public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
		int i = 0;
		while (i < intervals.size() && newInterval.start > intervals.get(i).end) {
			i++;
		}
		while (i < intervals.size() && newInterval.end >= intervals.get(i).start) {
			newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
			newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
			intervals.remove(i);
		}

		intervals.add(i, newInterval);
		return intervals;
	}
}