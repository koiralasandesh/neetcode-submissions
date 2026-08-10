class Solution {
    public int climbStairs(int n) {

        int prev=1;
        int curr=1;

        for (int i=0;i<n-1;i++){
            int temp = curr;
            curr=curr+prev;
            prev=temp;
        }

        return curr;

    }


}
