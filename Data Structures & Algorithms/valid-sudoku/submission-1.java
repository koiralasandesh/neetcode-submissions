class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if (board[i][j]!='.'){
                    if(!seen.add(board[i][j]+"@r"+i) ||
                    !seen.add(board[i][j]+"@c"+j) || 
                    !seen.add(board[i][j] + "@b"+ i/3 +"-"+j/3)
                    ){
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
