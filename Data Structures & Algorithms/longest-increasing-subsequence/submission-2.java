class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] memo = new int[nums.length][nums.length+1];
        Arrays.stream(memo).forEach(row-> Arrays.fill(row,-1));
        return backtrack(nums,0,-1,memo);
        
    }

    private int backtrack(int[] nums,int i, int prevPick,int[][] memo){
        if (i==nums.length) return 0;

        if (memo[i][prevPick+1]>-1) return memo[i][prevPick+1];

        int unPickMax = backtrack(nums,i+1,prevPick,memo);

        int pickMax=0;
        if (prevPick ==-1 || nums[prevPick]<nums[i]){
            pickMax = 1+backtrack(nums,i+1,i,memo); 
        }

        int result = Math.max(pickMax,unPickMax);
        memo[i][prevPick+1]=result;
        return result;

    }
}
