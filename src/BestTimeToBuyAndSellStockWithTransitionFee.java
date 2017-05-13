
//can perform as many transitions as possible in the same day, but with a fee

public class BestTimeToBuyAndSellStockWithTransitionFee {
	public int maxProfit(int[] prices, int[] fees) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int maxProfit = 0;
		for (int i = 1; i < prices.length; i++) {
			int buy = prices[i - 1] + fees[i - 1];
			int sell = prices[i] - fees[i];
			if (sell > buy) {
				maxProfit += sell - buy;
			}
		}
		return maxProfit;
	}
}
