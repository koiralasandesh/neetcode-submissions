class Solution {
    public int[] countBits(int n) {
        int [] result  = new int[n+1];
        result[0]=0;

        for (int i=n;i>=1;i--){
            int temp=i;
            int count =0;
            while(temp!=0){
                temp= temp& (temp-1);
                count++;
            }
            result[i]=count;

        }

        return result;
    }
}
