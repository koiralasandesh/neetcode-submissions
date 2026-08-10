class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        if (n==1){
            return grid[0][0];
        }

        //cost,i,j
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        boolean[][] visited = new boolean[n][n];
        int maxCost = grid[0][0];
        pq.offer(new int[]{maxCost,0,0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            maxCost=Math.max(maxCost,curr[0]);

            if (curr[1]== n-1 && curr[2]==n-1){
                return maxCost;
            }

            int i = curr[1];
            int j = curr[2];

            if (!visited[i][j]){
                visited[i][j]=true;
                
                if (isValid(i+1,j,n) && !visited[i+1][j]){
                    pq.offer(new int[]{Math.max(maxCost,grid[i+1][j]),i+1,j});
                }
                if (isValid(i-1,j,n) && !visited[i-1][j]){
                    pq.offer(new int[]{Math.max(maxCost,grid[i-1][j]),i-1,j});
                }
                if (isValid(i,j+1,n) && !visited[i][j+1]){
                    pq.offer(new int[]{Math.max(maxCost,grid[i][j+1]),i,j+1});
                }
                if (isValid(i,j-1,n) && !visited[i][j-1]){
                    pq.offer(new int[]{Math.max(maxCost,grid[i][j-1]),i,j-1});
                }

            }

        }

        return maxCost;

    }

    private boolean isValid(int i,int j,int n){
        if (i>=0 && j>=0 && j<n && i<n){
            return true;
        }
        return false;
    }
}
