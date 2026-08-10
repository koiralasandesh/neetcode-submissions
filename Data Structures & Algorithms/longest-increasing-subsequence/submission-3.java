// dynamic programming with 1d memo
class Solution {
    public int lengthOfLIS(int[] nums) {
        int result = 0;
        for (int i=0;i<nums.length;i++){
            result=Math.max(result,1+dfs(i,nums));
        }

        return result;
    }

    private int dfs(int i,int[] nums){
        int result =0;
        for (int j=i+1;j<nums.length;j++){
            if (nums[j]>nums[i]){
                result=Math.max(result,1+dfs(j,nums));
            }
        }
        return result;
    }
}
