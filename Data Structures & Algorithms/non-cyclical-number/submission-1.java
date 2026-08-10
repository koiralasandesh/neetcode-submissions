class Solution {
    public boolean isHappy(int n) {

        if (n==1) return true;
        
        int slow=n;
        int fast = sumOfSquares(n);
        while(true){
            if (fast==slow) return false;
            if (fast==1 || slow==1) return true;

            slow=sumOfSquares(slow);
            fast=sumOfSquares(sumOfSquares(fast));
        }
    }

    private int sumOfSquares(int n){
        String num = Integer.toString(n);
        int result = 0;
        for (char c: num.toCharArray()){
            int temp =Integer.valueOf(String.valueOf(c));
            result+=(temp*temp);
        } 
        return result;
    }
}
