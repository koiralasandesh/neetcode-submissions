class Solution {
    record Coord (int i,int j){}

    public int numIslands(char[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int count=0;


        for (int i =0;i<ROWS;i++){
            for (int j=0;j<COLS;j++){
                if (grid[i][j]=='1'){
                    bfs(i,j,grid, new ArrayDeque<Coord>());
                    count++;
                }
            }
        }

        return count;
    }

    private void bfs(int i, int j,char[][] grid,Queue<Coord> q){
        q.offer(new Coord(i,j));

        while(!q.isEmpty()){
            Coord node = q.poll();
            grid[node.i()][node.j()]='#';
            if (isValidCoord(node.i()-1,node.j(),grid)) {
                q.offer(new Coord(node.i()-1,node.j()));
            }
            if (isValidCoord(node.i()+1,node.j(),grid)) {
                q.offer(new Coord(node.i()+1,node.j()));
            }
            if (isValidCoord(node.i(),node.j()+1,grid)) {
                q.offer(new Coord(node.i(),node.j()+1));
            }
            if (isValidCoord(node.i(),node.j()-1,grid)) {
                q.offer(new Coord(node.i(),node.j()-1));
            }  
          
        }
        

    }

    private boolean isValidCoord(int i, int j,char[] []grid){
        if ( i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='#'){
            return false;
        }

        if (grid[i][j]=='1'){
            return true;
        }

        return false;
    }
}
