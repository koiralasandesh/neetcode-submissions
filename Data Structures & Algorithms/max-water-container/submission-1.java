class Solution {
    public int maxArea(int[] heights) {
        var left =0;
        var right=heights.length-1;
        var result=0;

        while(left<right){
            int height = Math.min(heights[left],heights[right]);
            int dist = right-left;

            int water = height*dist;

            result = Math.max(water,result);

            if (heights[left]==height){
                left++;
            }else{
                right--;
            }
        }

        return result;
    }
}
