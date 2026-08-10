/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[]{Integer.MIN_VALUE};
        dfs(root,max);
        
        return max[0];
    }

    private int dfs(TreeNode root, int[] max){
        if (root==null) return 0;

        int leftSum = dfs(root.left,max);
        int rightSum = dfs(root.right,max);

        max[0] = Math.max(max[0],(leftSum>0 ? leftSum : 0)+(rightSum>0? rightSum : 0)+root.val);
        return Math.max((leftSum>0 ? leftSum : 0),(rightSum>0? rightSum : 0))+root.val;
    }
}
