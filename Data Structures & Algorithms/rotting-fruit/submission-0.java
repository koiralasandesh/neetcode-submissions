class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        int freshFruits = 0;

        for(int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                if (grid[i][j]==1){
                    freshFruits++;
                }
            }
        }

        while(!q.isEmpty() && freshFruits>0){
            int size = q.size();
            for (int i=0;i<size;i++){
                int[] cell = q.poll();
                if (cellIsValid(cell[0]+1,cell[1],grid)){
                    grid[cell[0]+1][cell[1]]=2;
                    q.offer(new int[]{cell[0]+1,cell[1]});
                    freshFruits--;
                }
                if (cellIsValid(cell[0]-1,cell[1],grid)){
                    grid[cell[0]-1][cell[1]]=2;
                    q.offer(new int[]{cell[0]-1,cell[1]});
                    freshFruits--;
                }
                if (cellIsValid(cell[0],cell[1]+1,grid)){
                    grid[cell[0]][cell[1]+1]=2;
                    q.offer(new int[]{cell[0],cell[1]+1});
                    freshFruits--;
                }
                if (cellIsValid(cell[0],cell[1]-1,grid)){
                    grid[cell[0]][cell[1]-1]=2;
                    q.offer(new int[]{cell[0],cell[1]-1});
                    freshFruits--;
                }
            }
            time++;
        }

        if (freshFruits>0){
            return -1;
        }


        return time;
        
    }

    private boolean cellIsValid(int i,int j,int [][] grid){
        if (i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!=1){
            return false;
        }

        return true;
    }
}
