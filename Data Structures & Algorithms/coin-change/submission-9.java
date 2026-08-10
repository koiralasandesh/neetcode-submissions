class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins.length==0) return -1;
        if (amount==0) return 0;

        int [] dp = new int[amount+1];
        Arrays.fill(dp,-1);
        dp[0]=0;

        for (int i=1;i<amount+1;i++){
            int currWays = Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++){
                if (i-coins[j]<0 || dp[i-coins[j]]<0) continue;
                currWays=Math.min(currWays,dp[i-coins[j]]+1);
            }
            if(currWays<Integer.MAX_VALUE){
                dp[i]=currWays;
            }else{
                dp[i]=-1;
            }
        }

        return dp[amount];
    }
}
