class Solution {
    public int trap(int[] height) {
        int left =0,right=height.length-1;
        int maxleft = height[0];
        int maxright=height[height.length-1];
        int result=0;

        while (left<right){
            if (maxleft<maxright){
                result += maxleft-height[left];
                left++;
                maxleft = Math.max(maxleft,height[left]);
            }else{
                result+=maxright-height[right];
                right--;
                maxright=Math.max(maxright,height[right]);
            }
        }

        return result;

        
    }
}
