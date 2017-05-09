
public class Sqrt {
	public int mySqrt(int x) {
		if (x < 0) {
			return -1;
		}
		long start = 1;
		long end = x;
		long mid = 0;
		while (start <= end) {
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
