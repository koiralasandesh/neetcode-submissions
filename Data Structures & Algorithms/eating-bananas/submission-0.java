class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();
        int left = 1,right = max;

        int result = max;

        while (left<=right){
            int mid = (left +right)/2;
            
            int timeToEat = 0;
            
            for (int pile: piles){
                timeToEat+=Math.ceil((double)pile/mid);
            }

            if (timeToEat>h){
                left= mid+1;
            }else{
                right = mid-1;
                result = mid;
            }
        }

        return result;
    }
}
