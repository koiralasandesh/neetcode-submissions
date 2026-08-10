class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result= new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(0,candidates,target,subset,result);

        return result;
    }

    private void backtrack(int i,int[] candidates, int target,List<Integer> subset, List<List<Integer>> result){
        
        if (target ==0) {
            result.add(new ArrayList(subset));
            return;
        }
        if(i>=candidates.length || target<0 ) return;

        subset.add(candidates[i]);
        backtrack(i+1,candidates,target-candidates[i],subset,result);

        subset.remove(subset.size()-1);

        while(i<candidates.length-1 && candidates[i]==candidates[i+1]){
            i++;
        }
        backtrack(i+1,candidates,target,subset,result);

    }
}
