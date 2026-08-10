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
    public boolean isBalanced(TreeNode root) {
        int height = calculateHeight(root);

        if (height<0){
            return false;
        }

        return true;
        
    }

    private int calculateHeight(TreeNode root){
        if (root==null){
            return 0;
        }

        int leftHeight = calculateHeight(root.left);
        int rightHeight= calculateHeight(root.right);

        if (leftHeight<0 || rightHeight< 0){
            return -1;
        }

        if (Math.abs(leftHeight-rightHeight)>1){
            return -1;
        }

        return Math.max(leftHeight,rightHeight)+1;

    }
}
