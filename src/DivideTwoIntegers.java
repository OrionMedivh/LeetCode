
/*
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 */

public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
			return Integer.MAX_VALUE;
		}
		boolean isNegative = (dividend > 0 == divisor < 0);
		long dvd = Math.abs((long) dividend);
		// if not using long, abs(Integer.MIN_VALUE) will not be changed.
		long dvs = Math.abs((long) divisor);
		int res = 0;
		while (dvd >= dvs) {
			long temp = dvs;
			int multiple = 1;
			while ((temp << 1) <= dvd) {
				temp <<= 1;
				multiple <<= 1;
			}
			res += multiple;
			dvd = dvd - temp;
		}
		return isNegative ? -res : res;
	}
}
