class Solution {
    public int climbStairs(int n) {
        return dfs(n);  
    }

    private int dfs(int n){
        if (n<0) return 0;
        if (n==0){
            return 1;
        }
        return dfs(n-1)+dfs(n-2);
    }
}
