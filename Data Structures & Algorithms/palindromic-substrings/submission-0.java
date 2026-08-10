class Solution {
    public int countSubstrings(String s) {
        if (s.length()==0) return 0;
        if (s.length()==1) return 1;
        int result=0;

        // aaa
        for (int i=0;i<s.length();i++){
            int l=i;
            int r=i;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                result++;
                l--;
                r++;
            }

            l=i;
            r=i+1;

            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                result++;
                l--;
                r++;
            }

        }

        return result;

    }
}
