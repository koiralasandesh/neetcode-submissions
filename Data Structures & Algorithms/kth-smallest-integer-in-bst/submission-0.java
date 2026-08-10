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

    public int kthSmallest(TreeNode root, int k) {
        int[] temp = new int[] {k,0,-1};
        dfs(root,temp);
        return temp[2];
    }

    private void dfs(TreeNode root, int[] temp){
        if (root==null) return;

        dfs(root.left,temp);
        if (temp[2]>0) return;
        temp[1]=++temp[1];
        if (temp[1]==temp[0]) {
            temp[2]=root.val;
            return;
        }
        dfs(root.right,temp);
    }


}
