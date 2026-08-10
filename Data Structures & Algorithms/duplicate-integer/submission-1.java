class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet set = new HashSet();

        for (int i:nums){
            boolean result = set.add(i);
            if (!result){
                return true;
            }
        }
        return false;
    }
}