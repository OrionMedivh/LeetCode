import java.util.Random;

public class RandomlyChooseKSamplesFromList {

	/*
	 * Choose 1, 2, 3, ..., k first and put them into the reservoir. For k+1,
	 * pick it with a probability of k/(k+1), and randomly replace a number in
	 * the reservoir. For k+i, pick it with a probability of k/(k+i), and
	 * randomly replace a number in the reservoir. Repeat until k+i reaches n
	 */

	public int[] selectKItems(int[] stream, int k) {
		Random rand = new Random();
		int n = stream.length;
		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = stream[k];
		}

		for (int i = k; i < n; i++) {
			int j = rand.nextInt(i + 1);
			if (j < k) {
				res[j] = stream[i];
				// chances for i replace j is k/(k+i);
			}
		}
		return res;
	}
}
