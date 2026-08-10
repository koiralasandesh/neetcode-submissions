//num2 = 1 2 3 
//num1 = 4 5 6
//-------



// _ _ _ _ _ _

class Solution {
    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0") ) return "0";
        int n=num1.length()+num2.length();
        int[] result = new int[n];
        StringBuilder sb = new StringBuilder();

        for (int i=num1.length()-1;i>=0;i--){
            for (int j=num2.length()-1;j>=0;j--){
                int digit = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                result[i+j+1]+=digit;
                result[i+j]=result[i+j+1]/10+result[i+j];
                result[i+j+1]%=10;
            }
        }

        for (int i=0;i<result.length;i++){
            if (result[i]==0 && sb.length()==0){
                continue;
            }
            sb.append(result[i]);
        }

        return sb.toString();
    }
}
 