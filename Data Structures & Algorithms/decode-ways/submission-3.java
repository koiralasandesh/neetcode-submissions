//memoizing the prev solution

class Solution {
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo,-1);
        return backtrack(s,0, memo);

    }

    private int backtrack(String s,int index, int[] memo){
        if (index>s.length()-1) return 1;

        if (s.charAt(index)=='0') return 0;

        if (index==s.length()-1) return 1;

        if (memo[index]>=0) return memo[index];
        int result = backtrack(s,index+1,memo);

        if (s.length()>index+1 && (s.charAt(index)=='1' || 
            (s.charAt(index)=='2' && s.charAt(index+1)<'7'))){
                result+=backtrack(s,index+2,memo);
        }
        
        memo[index]=result;
        return result;
    }
}
 