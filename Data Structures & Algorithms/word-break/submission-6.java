class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<String>(wordDict);
        int[] memo = new int[s.length()+1];
        return dfs(s, wordSet,0, memo);
    }

    private boolean dfs(String s, Set<String> wordSet, int i,int[] memo){ // O(L)

        if (memo[i]>0) return memo[i]==1;
        if (i>=s.length()) {
            memo[i]=1;
            return true;
        }
        for (int j=i+1;j<s.length()+1;j++){ // O(L)
            String sub = s.substring(i,j);  // O(L)
            if (wordSet.contains(sub)){
                if (dfs(s,wordSet,j,memo)) {
                    return true;
                }
            }

        }
        memo[i]=2;
        return false;

    }


}

//total tc: O(L^2*N)
