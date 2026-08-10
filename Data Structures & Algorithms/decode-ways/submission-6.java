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
        int prev=0;
        int curr=1;

        for(int i=s.length()-1;i>=0;i--){
            int temp=0;
            if (s.charAt(i)!='0'){
                temp=curr;
                if(i<s.length()-1 && (s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)<'7'))){
                    temp=temp+prev;
                }

            }
            prev=curr;
            curr=temp;
        }

        return curr;

    }

} 