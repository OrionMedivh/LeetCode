import java.util.Random;

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class ReadNCharactersGivenRead4 {
	Random rand = new Random();

	public int read4(char[] buf) {
		return rand.nextInt(4);
	}

	/**
	 * @param buf
	 *            Destination buffer
	 * @param n
	 *            Maximum number of characters to read
	 * @return The number of characters read
	 */
	public int read(char[] buf, int n) {
		char[] buffer = new char[4];
		if (n < 0)
			return 0;
		int result = 0;
		while (n > result) {
			int count = read4(buffer);
			if (count == 0) {
				return result;
			}
			int cursize = Math.min(count, n - result);
			for (int i = 0; i < cursize; i++) {
				buf[i + result] = buffer[i];
			}
			result += cursize;
		}
		return result;
	}
}
