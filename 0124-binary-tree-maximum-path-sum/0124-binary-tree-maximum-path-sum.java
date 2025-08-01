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
    int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return maxPath;
    }

    public int pathSum(TreeNode root) {
        if(root == null) return 0;

        int left = Math.max(0, pathSum(root.left));
        int right = Math.max(0, pathSum(root.right));

        maxPath = Math.max(maxPath, left + right + root.val);

        return root.val + Math.max(left, right);
    }
}