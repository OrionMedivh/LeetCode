import java.util.ArrayList;
import java.util.List;

public class Combination {
	// public List<List<Integer>> combine(int n, int k) {
	// ArrayList<ArrayList<Integer>> result=new
	// ArrayList<ArrayList<Integer>>();
	// if (k==0) return result;
	// if (k==1) {
	// for (int i=1;i<=n;i++){
	// ArrayList<Integer> a=new ArrayList<Integer>();
	// a.add(i);
	// result.add(a);
	// }
	// return result;
	// }
	// if (n==k) {
	// ArrayList<Integer> a=new ArrayList<Integer>();
	// for(int i=1;i<=n;i++) a.add(i);
	// result.add(a);
	// return result;
	// }
	// result.addAll(combine(n-1,k));//C(n-1)k;
	// for (ArrayList<Integer> i:combine(n-1,k-1)){//C(n-1)k-1;
	// i.add(n);
	// result.add(i);
	// }
	// return result;
	// }

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> combs = new ArrayList<>();
		combine(combs, new ArrayList<Integer>(), 1, n, k);
		return combs;
	}

	public void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
		if (k == 0) {
			combs.add(new ArrayList<Integer>(comb));
			return;
		}
		for (int i = start; i <= n; i++) {
			comb.add(i);
			combine(combs, comb, i + 1, n, k - 1);
			comb.remove(comb.size() - 1);
		}
	}

	public static void main(String args[]) {
		Combination c = new Combination();
		System.out.println(c.combine(4, 2));
	}
}