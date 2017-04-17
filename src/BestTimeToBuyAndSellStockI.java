
public class BestTimeToBuyAndSellStockI
{
  public int maxProfit(int[] prices) {
    if( prices == null || prices.length < 2 ){
      return 0;
    }
    int global = 0, local = 0;
    for(int i = 0; i< prices.length - 1; i++){
      local = Math.max( prices[i+1] - prices[i], local + prices[i+1] - prices[i] ); // local max with selling at day i;
      global = Math.max( global, local );
    }
    return global;
  }
}
