class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left=0;
        int right = (rows * cols) -1;

        while(left <=right){
            int mid = left +(right-left)/2;

            int row = mid/cols;
            int col = mid%cols;

            int mid2d = matrix[row][col];

            if (mid2d == target){
                return true;
            }else if (mid2d>target){
                right= mid-1;
            } else{
                left = mid+1;
            }

        }

        return false;
    }
}
