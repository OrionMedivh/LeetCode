
public class SuperPow {

	int base = 1337;

	public int superPow(int a, int[] b) {
		return superPow(a, b, b.length - 1);
	}

	private int superPow(int a, int[] b, int end) {
		if (end == -1) {
			return 1;
		}
		int last = b[end];
		return powMod(superPow(a, b, end - 1), 10) * powMod(a, last) % base;
	}

	private int powMod(int a, int k) {
		a %= base;
		int result = 1;
		for (int i = 0; i < k; i++) {
			result = (result * a) % base;
		}
		return result;
	}
}
