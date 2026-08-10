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

    int maxHeight = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateMaxHeight(root);
        return maxHeight;
    }

    private int calculateMaxHeight(TreeNode node){
        if (node==null){
            return 0;
        }

        int leftSubtreeHeight = calculateMaxHeight(node.left);
        int rightSubtreeHeight = calculateMaxHeight(node.right);

        int diameter = leftSubtreeHeight + rightSubtreeHeight;
        this.maxHeight=Math.max(this.maxHeight,diameter);

        return Math.max(leftSubtreeHeight,rightSubtreeHeight)+1;

    }
}
