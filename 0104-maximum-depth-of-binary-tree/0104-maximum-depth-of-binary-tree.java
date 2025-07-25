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
    public int maxDepth(TreeNode root) {
        // Queue<TreeNode> q = new LinkedList<>();
        // if(root == null) return 0;
        // q.offer(root);
        // int depth = 0;

        // while(!q.isEmpty()) {
        //     int level = q.size();
        //     for(int i=0; i<level; i++) {
        //         if(q.peek().left != null) q.offer(q.peek().left);
        //         if(q.peek().right != null) q.offer(q.peek().right);
        //         q.poll();
        //     }
            
        //     depth++;
        // }
        // return depth;

        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}