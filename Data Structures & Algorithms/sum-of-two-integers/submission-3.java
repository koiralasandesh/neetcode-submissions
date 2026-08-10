class Solution {
    public int getSum(int a, int b) {
        while(a !=0){
            int sum = a^b;
            int carry = (a & b) <<1;
            a=carry;
            b=sum;
        }

        return b;

    }
}
