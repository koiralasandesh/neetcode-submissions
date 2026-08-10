class Solution {

    private record Coord (int x,int y){}
    public int maxAreaOfIsland(int[][] grid) {
        int[] result = new int[]{0};
        
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]==1){
                    bfs(result,grid,i,j, new ArrayDeque<Coord>());
                }
            }
        }

        return result[0];
    }

    private void bfs(int[] max,int[][] grid,int i,int j,Queue<Coord> q){
        grid[i][j]=-1;
        q.offer(new Coord(i,j));
        int count = 0;

        while(!q.isEmpty()){
            Coord coord = q.poll();
            count++;
            if (isCoordValid(coord.x()+1,coord.y(),grid)){
                grid[coord.x()+1][coord.y()]=-1;
                q.offer(new Coord(coord.x()+1,coord.y()));
            }
            if (isCoordValid(coord.x()-1,coord.y(),grid)){
                grid[coord.x()-1][coord.y()]=-1;
                q.offer(new Coord(coord.x()-1,coord.y()));
            }
            if (isCoordValid(coord.x(),coord.y()+1,grid)){
                grid[coord.x()][coord.y()+1]=-1;
                q.offer(new Coord(coord.x(),coord.y()+1));
            }
            if (isCoordValid(coord.x(),coord.y()-1,grid)){
                grid[coord.x()][coord.y()-1]=-1;
                q.offer(new Coord(coord.x(),coord.y()-1));
            }
        }

        max[0]=Math.max(max[0],count);
    }

    private boolean isCoordValid(int i,int j,int[][] grid){
        if(i<0 || j< 0 || i>=grid.length || j>= grid[0].length || grid[i][j]<1){
            return false;
        }

        return true;
    }
}
