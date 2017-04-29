public class BestTimeStock {
    public int maxProfit(int[] prices) {
        int len=prices.length;
        if (len==0) return 0;
        if (len==1) return 0;
        int curMax=0;
        int Max=0;
        for (int i=0;i<len-1;i++){
            curMax=Math.max(curMax+prices[i+1]-prices[i],prices[i+1]-prices[i]);
            Max=Math.max(curMax,Max);
        }
        return Max;
    }
}