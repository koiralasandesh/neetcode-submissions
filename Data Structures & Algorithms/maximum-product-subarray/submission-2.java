class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int result= Integer.MIN_VALUE;

        int pSum=1;
        int sSum=1;

        for(int i=0;i<n;i++){
            pSum*=nums[i];
            sSum*=nums[n-i-1];
            
            result=Math.max(result,Math.max(pSum,sSum));

            if (pSum==0) pSum=1;
            if (sSum==0) sSum=1;

        }
        return result;
    }
}
