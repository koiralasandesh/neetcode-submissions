// dynamic programming bottoms up
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[nums.length-1]=1;

        int result=1;

        for (int i=nums.length-2;i>=0;i--){
            int maxStart=0;
            for (int j=i+1;j<nums.length;j++){
                if(nums[j]>nums[i]){
                    maxStart=Math.max(maxStart,dp[j]);
                }
            }
            maxStart++;
            dp[i]=maxStart;
            result= Math.max(result,maxStart);

        }

        return result;        
    }
}
