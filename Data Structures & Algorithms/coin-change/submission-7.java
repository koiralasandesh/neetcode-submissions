class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins.length==0) return -1;
        if (amount==0) return 0;

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[amount+1];
        int result=0;
        
        q.add(0);
        visited[0]=true;

        while(!q.isEmpty()){
            int size = q.size();
            result++;
            for (int i=0;i<size;i++){
                int currSum=q.poll();
                for (int j=0;j<coins.length;j++){
                    int newSum=currSum+coins[j];
                    if (newSum>amount){
                        continue;
                    }
                    if (newSum==amount){
                        return result;
                    }
                    if (!visited[newSum]){
                        visited[newSum]=true;
                        q.offer(newSum);
                    }
                }
            }
        }
        return -1;
    }
}
