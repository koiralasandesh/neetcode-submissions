class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] memo = new int[s.length()+1];
        return dfs(s, wordDict,0, memo);
    }

    private boolean dfs(String s, List<String> wordDict, int i,int[] memo){ // O(L)

        if (memo[i]>0) return memo[i]==1;
        if (i>=s.length()) {
            memo[i]=1;
            return true;
        }
        for (int j=i+1;j<s.length()+1;j++){ // O(L)
            String sub = s.substring(i,j);  // O(L)
            for (String word: wordDict){   //O(N)
                if(sub.equals(word)){
                    if (dfs(s,wordDict,j,memo)) {
                        memo[i]=1;
                        return true;
                    }
                }
            }

        }
        memo[i]=2;
        return false;

    }


}

//total tc: O(L^2*N)
