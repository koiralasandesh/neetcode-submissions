class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==0) return s;
        int maxLength = -1;
        int maxCenter = -1;

        for (int i =0;i<s.length();i++){
            int length = helper(i,i,s);
            if (length>maxLength){
                maxLength=length;
                maxCenter=i;
            }

            length = helper(i,i+1,s);
            if (length>maxLength){
                maxLength=length;
                maxCenter=i;
            }

        } 
        return s.substring(maxCenter-((maxLength)-1)/2,maxCenter+(maxLength/2)+1);
    }

    private int helper(int l,int r,String s){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }
}
