class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length==0){
            return 0;
        }
        var set =Arrays.stream(nums).boxed().collect(Collectors.toSet());

        int result = 1;

        for (int n:nums){
            if (set.contains(n-1)){
                continue;
            }else{
                int num=n;
                while(set.contains(num+1)){
                    num++;
                }
                result = Math.max(result,num-n+1);
            }
        }
        return result;
    }
}
