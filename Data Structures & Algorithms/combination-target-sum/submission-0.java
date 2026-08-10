class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<Integer>();

        backtrack(0,nums,target,subset,result);

        return result;
    }

    private void backtrack(int i,int[] nums,int target,List<Integer> subset,List<List<Integer>> result ){
        if (i>=nums.length) return;
        if (target==0){
            result.add(new ArrayList(subset));
            return;
        }

        if (target<0){
            return;
        }


        subset.add(nums[i]);
        backtrack(i,nums,target-nums[i],subset,result);
        subset.remove(subset.size()-1);
        backtrack(i+1,nums,target,subset,result);
    }
}
