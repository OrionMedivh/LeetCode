import java.util.ArrayList;
import java.util.List;

class Tuple {
	int val, idx;

	Tuple(int val, int idx) {
		this.val = val;
		this.idx = idx;
	}
}

public class DotProduct {

	// regular
	public int docProduct(int[] a, int[] b) {
		int len = a.length;
		int res = 0;
		for (int i = 0; i < len; i++) {
			res += a[i] * b[i];
		}
		return res;
	}

	// sparse
	public int docProduct2(int[] a, int[] b) {
		int res = 0;
		if (a.length != b.length) {
			return res;
		}
		List<Tuple> l1 = new ArrayList<>();
		List<Tuple> l2 = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			if (a[i] != 0) {
				l1.add(new Tuple(a[i], i));
			}
			if (b[i] != 0) {
				l2.add(new Tuple(b[i], i));
			}
		}
		int i = 0, j = 0;
		while (i < l1.size() && j < l2.size()) {
			if (l1.get(i).idx < l2.get(j).idx) {
				i++;
			} else if (l1.get(i).idx < l2.get(j).idx) {
				j++;
			} else { // ==
				res += l1.get(i).val * l2.get(j).val;
				i++;
				j++;
			}
		}
		return res;
	}
}
