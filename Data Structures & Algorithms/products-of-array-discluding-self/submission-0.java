class Solution {
    public int[] productExceptSelf(int[] nums) {
       int prefixProduct[] = new int[nums.length];
       int suffixProduct[] = new int [nums.length]; 

       prefixProduct[0] = 1;

       suffixProduct[nums.length-1]= 1;

       for(int i=1;i<nums.length;i++){
        prefixProduct[i]= prefixProduct[i-1]*nums[i-1];
        System.out.println("i="+i);
        System.out.println("prefixProduct="+prefixProduct[i]);
       }

       for(int j=(nums.length-2);j>=0;j--){
        suffixProduct[j]= suffixProduct[j+1]*nums[j+1];
        System.out.println("j="+j);
        System.out.println("suffixProduct="+suffixProduct[j]);
       }

       int result [] = new int[nums.length];

       for (int k=0; k<nums.length;k++){
        result[k] = prefixProduct[k]*suffixProduct[k];
        System.out.println("k="+k);
        System.out.println("result="+result[k]);
       }

       return result;
    }
}  