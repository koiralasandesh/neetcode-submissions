class Solution {
    public int numDecodings(String s) {
        return backtrack(s,0);
    }

    private int backtrack(String s,int index){
        if (index>s.length()-1) return 1;

        if (s.charAt(index)=='0') return 0;

        if (index==s.length()-1) return 1;

        int result = backtrack(s,index+1);

        if (s.length()>index+1 && (s.charAt(index)=='1' || 
            (s.charAt(index)=='2' && s.charAt(index+1)<'7'))){
                result+=backtrack(s,index+2);
        }

        return result;
    }
}
 