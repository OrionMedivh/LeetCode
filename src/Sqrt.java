
public class Sqrt {
	public int mySqrt(int x) {
		if (x < 0) {
			return -1;
		}
		long start = 0;
		long end = x;
		long mid = 0;
		while (start <= end) {
			// because the last loop is start = mid = end,
			// if not break in between
			mid = start + (end - start) / 2;
			if (mid * mid <= x && (mid + 1) * (mid + 1) > x) {
				break;
			} else if (mid * mid > x) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return (int) mid;
	}
}
