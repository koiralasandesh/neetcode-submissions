class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount ==0) return 0;
        
        if (coins.length ==0 ) return 0;

        int[] memo = new int[amount+1];
        Arrays.fill(memo,-2);

        return dfs(coins,amount,memo);
    }

    private int dfs(int[] coins, int currSum, int[] memo){
        if (currSum <0) return -1;

        if (currSum ==0) return 0;

        if (memo[currSum]>-2) return memo[currSum];

        int sol = Integer.MAX_VALUE;
        for (int i=0;i<coins.length;i++){
            int result=dfs(coins,currSum-coins[i],memo);
            if (result>=0){
                sol = Math.min(sol,result+1);
            }
        }
        if (sol==Integer.MAX_VALUE){
            memo[currSum]=-1;
            return -1;
        }

        memo[currSum]=sol;
        return sol;

    }



}
