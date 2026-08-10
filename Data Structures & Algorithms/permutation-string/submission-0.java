class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int [] s1freq = new int[26];

        for (char c: s1.toCharArray()){
            s1freq[c-'a']++;
        }

        int left = 0;
        int right=left+s1.length()-1;

        while(right<s2.length()){
            int [] s2freq = new int [26];
            for (char d: s2.substring(left,right+1).toCharArray()){
                s2freq[d-'a']++;
            }

            if (Arrays.equals(s1freq,s2freq)){
                return true;
            }else{
                left++;
                right++;
            }
        }

        return false;



    }
}
