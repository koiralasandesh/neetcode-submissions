class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backtrack(result,"",0,0,n);

        return result;
        
    }

    private void backtrack(List<String> result,String currentString,int numOpenPar, int numClosedPar, int n){

        if (currentString.length()==2*n){
            result.add(currentString);
            return;
        }

        if (numOpenPar<n){
            backtrack(result,currentString+"(",numOpenPar+1,numClosedPar,n);
        }

        if (numClosedPar<numOpenPar){
            backtrack(result,currentString + ")",numOpenPar,numClosedPar+1,n);
        }
    }
}
