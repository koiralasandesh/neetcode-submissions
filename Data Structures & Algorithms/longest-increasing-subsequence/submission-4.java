// dynamic programming with 1d memo
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo,-1);
        int result = 1;
        for (int i=0;i<nums.length;i++){
            result=Math.max(result,dfs(i,nums,memo));
        }

        return result;
    }

    private int dfs(int i,int[] nums,int[] memo){

        if (i==nums.length) return 1;

        if (memo[i]>-1) return memo[i];

        int result =1;
        for (int j=i+1;j<nums.length;j++){
            if (nums[j]>nums[i]){
                result=Math.max(result,1+dfs(j,nums,memo));
            }
        }
        memo[i] = result;
        return result;
    }
}
