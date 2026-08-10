class Solution {
    public String longestPalindrome(String s) {
        // l,r,maxL,maxR,maxL
        int[] result = new int[]{-1,-1,-1,-1,-1};
        for (int i =0;i<s.length();i++){
            result[0]=i;
            result[1]=i;
            helper(result,s);
            
            result[0]=i;
            result[1]=i+1;
            helper(result,s);
        } 
        return s.substring(result[2],result[3]+1);
    }

    private void helper(int[] result,String s){
        while(result[0]>=0 && result[1]<s.length() && s.charAt(result[0])==s.charAt(result[1])){
            int length = result[1]-result[0]+1;
            if (length>result[4]){
                result[4]=length;
                result[2] = result[0];
                result[3]=result[1];

            }
            result[0]--;
            result[1]++;
        }
    }
}
