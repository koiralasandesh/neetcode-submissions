class Solution {

    private record Coord(Integer row, Integer column){}

    public boolean exist(char[][] board, String word) {
        Set<Coord> visited = new HashSet<>();
        int r=board.length;
        int c=board[0].length;

        for (int i=0;i<r;i++){
            for (int j=0;j<c;j++){
               if(backtrack(board,word,visited,i,j,0)){
                return true;
               }
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, String word, Set<Coord> visited, int r, int c, int i){
        if (i==word.length()){
            return true;
        }

        Coord curr = new Coord(r,c);

        if (r<0 || c<0 || r>=board.length || c>= board[0].length || i>word.length() 
            || visited.contains(curr)
            || board[r][c] != word.charAt(i)){
            return false;
        }

        visited.add(curr);

        boolean result = backtrack(board,word,visited,r+1,c,i+1) ||
            backtrack(board,word,visited,r-1,c,i+1) ||
            backtrack(board,word,visited,r,c+1,i+1) ||
            backtrack(board,word,visited,r,c-1,i+1) ;

        visited.remove(curr);

        return result;


    }
}
