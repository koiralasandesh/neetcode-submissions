class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> rows = new ArrayList<>();
        Set <Integer> usedCols = new HashSet<>();
        Set <Integer> lrDiag = new HashSet<>();
        Set <Integer> rlDiag = new HashSet<>();

        backtrack(0,n,rows,usedCols,lrDiag,rlDiag,result);
        return result;
    }

    private void backtrack(int row,int n,List<String> rows,Set <Integer> usedCols,Set <Integer> lrDiag,Set <Integer> rlDiag, List<List<String>> result){
        if (row==n){
            result.add(new ArrayList(rows));
            return;
        }

        for (int col=0;col<n;col++){
            if (!usedCols.contains(Integer.valueOf(col)) && !rlDiag.contains(Integer.valueOf(row-col)) && !lrDiag.contains(Integer.valueOf(row+col))){

               lrDiag.add(col+row);
               rlDiag.add(row-col);
               usedCols.add(col);

               StringBuilder sb = new StringBuilder();
               for (int i=0;i<n;i++){
                if (i==col){
                    sb.append("Q");
                }else{
                    sb.append(".");
                }
               }
               rows.add(sb.toString());


               backtrack(row+1,n,rows,usedCols,lrDiag,rlDiag,result);


               lrDiag.remove(Integer.valueOf(col+row));
               rlDiag.remove(Integer.valueOf(row-col));
               usedCols.remove(Integer.valueOf(col));

               rows.remove(rows.size()-1);
            }
        }
    }
}
