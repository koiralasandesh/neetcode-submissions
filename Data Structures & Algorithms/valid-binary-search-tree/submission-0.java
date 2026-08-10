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
    public boolean isValidBST(TreeNode root) {
        return dfsHelper(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean dfsHelper(TreeNode root,int min, int max){
        if(root==null) return true;
        
        if (root.val >=max || root.val<=min) return false;

        boolean result = ((root.left!=null)? root.val>root.left.val: true && 
            (root.right!=null)? root.val<root.right.val: true);
        
        if (result){
            boolean leftResult = dfsHelper(root.left,min,root.val);
            boolean rightResult = dfsHelper(root.right,root.val,max);

            return leftResult && rightResult;
        }

        return result;
    }
}
