class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        Queue<int[]> q = new ArrayDeque<>();
        for (int i=0;i<rows;i++){
            if (board[i][0]=='O'){
                board[i][0]='U';
                q.offer(new int[]{i,0});
            }
            if (board[i][cols-1]=='O'){
                board[i][cols-1]='U';
                q.offer(new int[]{i,cols-1});
            }
        }

        for(int j=1;j<cols-1;j++){
            if (board[0][j]=='O'){
                board[0][j]='U';
                q.offer(new int[]{0,j});
            }
            if (board[rows-1][j]=='O'){
                board[rows-1][j]='U';
                q.offer(new int[]{rows-1,j});
            }
        }

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int i = cell[0];
            int j = cell[1];

            if (isCellValid(i+1,j,board)){
                board[i+1][j]='U';
                q.offer(new int[]{i+1,j});
            }
            if (isCellValid(i-1,j,board)){
                board[i-1][j]='U';
                q.offer(new int[]{i-1,j});
            }
            if (isCellValid(i,j+1,board)){
                board[i][j+1]='U';
                q.offer(new int[]{i,j+1});
            }
            if (isCellValid(i,j-1,board)){
                board[i][j-1]='U';
                q.offer(new int[]{i,j-1});
            }
        }

        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }

        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if(board[i][j]=='U'){
                    board[i][j]='O';
                }
            }
        }

        
    }

    private boolean isCellValid(int i, int j,char[][] board){
        if (i<0 || j<0 || i>=board.length || j>= board[0].length || board[i][j]!='O'){
            return false;
        }

        return true;
    }
}