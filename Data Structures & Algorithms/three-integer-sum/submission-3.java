class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> result = new ArrayList<>();

        for (int i=0;i<nums.length-2;i++){
            System.out.println("i="+i);
            if ( i>0 && nums[i]==nums[i-1]){
                continue;
            }

            int left =i+1, right = nums.length-1, target = nums[i]*(-1);
            System.out.println("left="+left+" right="+right+" target="+ target);

            while(left<right){

                // while(nums[left]==nums[left-1]){
                //     left++;
                //     System.out.println("left="+left);
                // }

                // while(nums[right]==nums[right-1]){
                //     right--;
                //     System.out.println("right="+right);
                // }

                if (nums[left]+nums[right]>target){
                    right--;
                }
                else if (nums[left]+nums[right]<target){
                    left++;
                }
                else{
                    result.add(List.of(nums[i],nums[left],nums[right]));
                    System.out.println("added to result,"+ nums[i]+","+nums[left]+","+nums[right]);
                    left++;
                    while(left<right && nums[left]==nums[left-1] ){
                        left++;
                    }
                }

                System.out.println("left="+left+" right="+right);

            }
        }
        return result;
    }
}
