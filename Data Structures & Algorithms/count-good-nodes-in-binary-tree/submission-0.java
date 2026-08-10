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

    int count=0;

    public int goodNodes(TreeNode root) {
        dfsHelper(Integer.MIN_VALUE,root);
        return count;
    }

    private void dfsHelper(int max, TreeNode root){
        if(root==null) return;
        if (root.val>=max) count++;
        dfsHelper(Math.max(max,root.val),root.left);
        dfsHelper(Math.max(max,root.val),root.right);
    }
}
