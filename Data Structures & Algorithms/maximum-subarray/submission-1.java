class Solution {
    public int maxSubArray(int[] nums) {
        int result =Integer.MIN_VALUE;
        int runningPSum= 0;

        for(int i=0;i<nums.length;i++){
            runningPSum +=nums[i];

            result=Math.max(result,runningPSum);
            if (runningPSum<0) runningPSum=0;
        }

        return result;
    }
}
