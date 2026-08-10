class Solution {
    public int characterReplacement(String s, int k) {
        int result = 0;
        int l=0;

        int maxFreq=0;
        int [] freqMap = new int[26];

        for (int r=0;r<s.length();r++){
            freqMap[s.charAt(r)-'A']++;
            maxFreq=Math.max(maxFreq,freqMap[s.charAt(r)-'A']);
            
            if (r-l+1-maxFreq > k ){
                freqMap[s.charAt(l)-'A']--;
                l++;
            }

            result = Math.max(result,r-l+1);
        }

        return result;
        
    }
}
