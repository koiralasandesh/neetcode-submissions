class Solution {
    public int climbStairs(int n) {
        if (n<=0) return 0;
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        dp[1]=1;

        dfs(n,dp);
        return dp[n];

    }

    private int dfs(int n, int[] dp){
        if (n<=0) return 0;
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }        
        if (dp[n]>=0){
            return dp[n];
        }
        dp[n]=dfs(n-1,dp)+dfs(n-2,dp);
        return dp[n];
    }
}
