class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]>   q = new ArrayDeque<>();

        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]==0){
                    q.offer(new int[]{i,j});
                }
            }
        } 

        int distance = 1;

        while(!q.isEmpty()){
            int size= q.size();
            for (int i=0;i<size;i++){
                int [] cell = q.poll();
                addIfValid(cell[0]+1,cell[1],grid,q,distance);
                addIfValid(cell[0],cell[1]+1,grid,q,distance);
                addIfValid(cell[0]-1,cell[1],grid,q,distance);
                addIfValid(cell[0],cell[1]-1,grid,q,distance);
            }
            distance++;

        }
    }

    private void addIfValid(int i, int j,int [][] grid, Queue<int[]> q,int distance){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!=Integer.MAX_VALUE){
            return;
        }
        grid[i][j]=distance;
        q.offer(new int[]{i,j});
    }
}
