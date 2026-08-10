class Solution {
    public int maxProfit(int[] prices) {
        int l=0,r=1;
        int profit =0;

        while (r<=prices.length-1){
            if (prices[r]<prices[l]){
                l=r;
                r=l+1;
            }else{
                profit = Math.max(profit,(prices[r]-prices[l]));
                r++;
            }
        }

        return profit;
    }
}
