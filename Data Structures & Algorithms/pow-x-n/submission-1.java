class Solution {
    public double myPow(double x, int n) {
        return dfs(x,n);
    }

    private double dfs(double x,int n){
        if (n==1) return x;
        if (n==0) return 1;

        long temp = Math.abs(n);

        double result=dfs(x,(int)temp/2);
        result=result*result;
        if (temp%2>0){
            result*=x;
        }

        return (temp!=(long)n)? 1/result : result;
    }
}
