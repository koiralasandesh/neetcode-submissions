class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);

        backtrack(0,nums,subset,result);

        return result;
    }

    private void backtrack(int index,int[] nums,List<Integer> subset,List<List<Integer>> result ){
        if (index>=nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        backtrack(index+1,nums,subset,result);

        subset.remove(subset.size()-1);
        while(index<nums.length-1 && nums[index]==nums[index+1]){
            index++;
        }
        backtrack(index+1,nums,subset,result);

    }
}
