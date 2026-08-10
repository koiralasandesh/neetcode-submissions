class Solution {
    public int maxSubArray(int[] nums) {
        int result =Integer.MIN_VALUE;
        int runningPSum= 0;
        int runningSSum= 0;

        for(int i=0;i<nums.length;i++){
            runningPSum +=nums[i];
            runningSSum +=nums[nums.length-i-1];

            result=Math.max(result,Math.max(runningPSum,runningSSum));
            if (runningPSum<0) runningPSum=0;
            if (runningSSum<0) runningSSum=0;
        }

        return result;
    }
}
