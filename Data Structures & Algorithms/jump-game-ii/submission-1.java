class Solution {
    public int jump(int[] nums) {

        if (nums.length ==1) return 0;
        
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[nums.length];
        int result = 0;

        visited[0]=true;
        q.offer(0);

        while(!q.isEmpty()){
            result++;
            int size=q.size();
            for (int i=0;i<size;i++){
                int index=q.poll();
                int j=index+1;
                while(j<nums.length && j<=index+nums[index]){
                    if (j==nums.length-1) return result;

                    if (!visited[j]){
                        visited[j]=true;
                        q.offer(j);
                    }
                    j++;
                }
            }
        }

        return result;
    }
}
