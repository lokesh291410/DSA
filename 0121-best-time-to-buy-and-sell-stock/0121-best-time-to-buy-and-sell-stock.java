class Solution {
    public int maxProfit(int[] prices) {
        // int buy = Integer.MAX_VALUE;
        // int profit = 0;

        // for(int i=0; i<prices.length; i++) {
        //     if(prices[i] < buy) buy = prices[i];
        //     profit = Math.max(prices[i]-buy, profit);
        // }
        // return profit;
        int[] left=new int[prices.length];
        int[] right=new int[prices.length];
        left[0]=prices[0];
        right[prices.length-1]=prices[prices.length-1];
        for(int i=1;i<prices.length;i++){
            left[i]=Math.min(left[i-1],prices[i]);
        }
        for(int i=prices.length-2;i>=0;i--){
            right[i]=Math.max(right[i+1],prices[i]);
        }
        int max=0;
        for(int i=0;i<prices.length;i++){
            max=Math.max(max,right[i]-left[i]);
        }
        return max;
    }
}