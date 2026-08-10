class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];

        int minus2=nums[0];
        int minus1= Math.max(minus2,nums[1]);


        for (int i=2;i<nums.length;i++){
            int temp=minus1;
            minus1=Math.max(minus2+nums[i],minus1);
            minus2=temp;
        }

        return minus1;
    }


}
