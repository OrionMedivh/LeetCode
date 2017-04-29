public class BestTimeStockIII {
    public static int maxProfit(int[] prices) {
        if (prices.length<=1) return 0;
        int[] Max1=new int[prices.length];
        Max1[0]=0;
        int[] Max2=new int[prices.length];
        Max2[prices.length-1]=0;
        int current=0;
        int max=0;
        for (int i=0;i<prices.length-1;i++){
            current=Math.max(current+prices[i+1]-prices[i],prices[i+1]-prices[i]);
            max=Math.max(max,current);
            Max1[i+1]=max;
        }
        max=0;
        current=0;
        for (int j=prices.length-2;j>=0;j--){
            current=Math.max(current+prices[j+1]-prices[j],prices[j+1]-prices[j]);
            max=Math.max(max,current);
            Max2[j]=max;
        }
        max=0;
        for(int k=0;k<prices.length;k++){
            max=Math.max(max,Max1[k]+Max2[k]);
        }
        return max;
    }
    
    public static void main(String[] args){
    	int[] input=new int[]{1,2};
    	System.out.println(maxProfit(input));
    }
}