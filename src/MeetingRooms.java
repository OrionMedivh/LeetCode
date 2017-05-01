import java.util.Arrays;

public class MeetingRooms {
	public boolean canAttendMeetings(Interval[] intervals) {
		Arrays.sort(intervals, (x, y) -> (x.start - y.start));
		for (int i = 0; i < intervals.length - 1; i++) {
			if (intervals[i].end > intervals[i + 1].start) {
				return false;
			}
		}
		return true;
	}
}
