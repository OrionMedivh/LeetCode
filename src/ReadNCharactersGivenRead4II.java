import java.util.Random;

public class ReadNCharactersGivenRead4II {

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

	private int count = 0;// number of chars in buffer
	private char[] buffer = new char[4];
	private int pointer = 0;// pointer in buffer

	public int read(char[] buf, int n) {
		if (n <= 0)
			return 0;
		int result = 0;
		while (n > result) {
			if (pointer == 0) {
				count = read4(buffer); // read new
			}
			if (count == 0) { // end of file
				return result;
			}
			int cursize = Math.min(count - pointer, n - result);
			for (int i = 0; i < cursize; i++) {
				buf[i + result] = buffer[i + pointer];
			}
			pointer += cursize;
			if (pointer >= count) {
				pointer = 0;
			}
			result += cursize;
		}
		return result;
	}
}
