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

        if (root==null) return new ArrayList<Integer>();

        Queue<TreeNode> q= new ArrayDeque<>();

        List<Integer> result = new ArrayList<>();

        q.offer(root);

        while(!q.isEmpty()){
            int levelSize = q.size();
            for(int i=0;i<levelSize;i++){
                TreeNode node = q.poll();
                if (levelSize-1==i) result.add(node.val);
                if (node.left!=null) q.offer(node.left);
                if (node.right!=null) q.offer(node.right);
            }
        }

        return result; 
    }

}
