class Solution {
    public int longestConsecutive(int[] nums) {
        Set <Integer> set = new HashSet<>();
        int result = 0;

        for (int num:nums){
            set.add(num);
        }

        for (int num:nums){
            if (!set.contains(num-1)){
                int currentStreak= 1;
                while(set.contains(num+currentStreak)){
                    currentStreak++;
                }
                result= Math.max(result,currentStreak);
            }
        }
        return result;
    }
}
