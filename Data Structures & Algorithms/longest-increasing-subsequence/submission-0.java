class Solution {
    public int lengthOfLIS(int[] nums) {

        return backtrack(nums,0,-1);
        
    }

    private int backtrack(int[] nums,int i, int prevPick){
        if (i==nums.length) return 0;

        int unPickMax = backtrack(nums,i+1,prevPick);

        int pickMax=0;
        if (prevPick ==-1 || nums[prevPick]<nums[i]){
            pickMax = 1+backtrack(nums,i+1,i); 
        }

        return Math.max(pickMax,unPickMax);

    }
}
