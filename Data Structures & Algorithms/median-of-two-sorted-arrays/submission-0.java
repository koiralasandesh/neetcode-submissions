class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList <Integer> arr1 = new ArrayList<>(Arrays.stream(nums1).boxed().toList());
        Arrays.stream(nums2).forEach(arr1::add);

        Collections.sort(arr1);
        
        int n = arr1.size();
        if (n%2 ==1){
            return arr1.get(n/2);
        }else{
            return (arr1.get(n/2 -1) + arr1.get(n/2))/2.0;
        }
    }
}
