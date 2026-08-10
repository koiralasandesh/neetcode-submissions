class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        backtrack(nums,0,subset,result);

        return result;
    }

    private void backtrack(int[] nums, int index, List<Integer> subset,List<List<Integer>> result){
        if (index>=nums.length){
            result.add(new ArrayList(subset));
            return;
        }
        subset.add(nums[index]);
        backtrack(nums,index+1,subset,result);
        subset.remove(Integer.valueOf(nums[index]));
        backtrack(nums,index+1,subset,result);
    }
}
