class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        StringBuilder current = new StringBuilder();

        backtrack(n,0,0,current,result);

        return result;
    }

    private void backtrack(int n,int openPar, int closedPar,StringBuilder current,List<String> result){
        if (openPar == n && closedPar==openPar ){
            result.add(current.toString());
            return;
        }
        if (openPar<n){
            current.append("(");
            backtrack(n,openPar+1,closedPar,current,result);
            current.deleteCharAt(current.length()-1);
        }
        if(openPar>closedPar){
            current.append(")");
            backtrack(n,openPar,closedPar+1,current,result);
            current.deleteCharAt(current.length()-1);
        }


    }
}
