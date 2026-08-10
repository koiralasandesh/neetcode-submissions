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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root==null) return result;

        dfsHelper(0,root,result);

        return result;
    }

    private void dfsHelper(int depth,TreeNode root, List<Integer> result){
        if (root==null) return;
        if (result.size() == depth) result.add(root.val);
        dfsHelper(depth+1,root.right,result);
        dfsHelper(depth+1,root.left,result);
    }

}
