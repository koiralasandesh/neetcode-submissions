//bottoms up
//                         1
//                     1
//                 2
//             0
//         0
//     0
// 0
 
// 1   5   6   0   2   1    
class Solution {
    public int numDecodings(String s) {
        int [] dp = new int [s.length()+1];
        dp[s.length()]=1;

        for(int i=s.length()-1;i>=0;i--){
            int ways=0;
            if (s.charAt(i)=='0'){
                dp[i]=0;
            }else{
                dp[i]=dp[i+1];
                if(i<dp.length-2 && (s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)<'7'))){
                    dp[i]=dp[i]+dp[i+2];
                }

            }
        }

        return dp[0];

    }

} 