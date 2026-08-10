class Solution {
    public int[] plusOne(int[] digits) {
        int carry =0;
        int n=digits.length;
        int[] result;

        for (int i=n-1;i>=0;i--){
            int temp = digits[i];
            if (i==n-1){
                temp++;
            }else{
                temp+=carry;
            }
            digits[i]=(temp)%10;
            carry = (temp)/10;
        }

        if (carry>0){
            result= new int[n+1];
            result[0]=carry;
            for (int i=1;i<n+1;i++){
                result[i]=digits[i-1];
            }
        }else{
            result = digits.clone();
        }

        return result;
    }
}
