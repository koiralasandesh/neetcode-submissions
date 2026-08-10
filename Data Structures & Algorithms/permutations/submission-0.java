class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<Integer>();
        boolean [] state = new boolean[nums.length];

        perm(nums,state,curr,result);

        return result;

    }

    private void perm (int[] nums,boolean[] state,List<Integer> curr,List<List<Integer>> result){
        if (curr.size()==nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if(!state[i]){
                curr.add(nums[i]);
                state[i]=true;
                perm(nums,state, curr,result);
                curr.remove(curr.size()-1);
                state[i]=false;
            }
        }
    }
}
