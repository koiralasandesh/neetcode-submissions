class Solution {
    public boolean isValidSudoku(char[][] board) {
        var row = new HashSet<String>();
        var col = new HashSet<String>();

        var small = new HashSet<String>();

        //rows i=0
        for (int i=0;i<board.length;i++){
            //cols j=1
            for (int j=0;j<board[i].length;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                if (!row.add(board[i][j]+","+i)){
                    return false;
                }
                if (!col.add(board[i][j]+","+j)){
                    return false;
                }
                if (!small.add(board[i][j]+","+((i/3)*board[0].length)+(j/3))){
                    return false;
                }
            }
        }
        return true;
    }
}



// 0,1 0,2 0,3 ...
// 1,0 2,0 3,0 ...

// row= 1,0
// col= 1,0

// smaller_grid = 1,0/9

// 0,1

// 1,0

// 2=1,3   2,1/9,3/9 2,1/9,1/3
// 2=0,1   2,0/9,1/9 

// 2=2,5   2,2/9,5/9

//2=0,1     2,0/3,1/3

// 2=1,2   2,1/3,2/3

// 2 = 2,3     2,2/3,1