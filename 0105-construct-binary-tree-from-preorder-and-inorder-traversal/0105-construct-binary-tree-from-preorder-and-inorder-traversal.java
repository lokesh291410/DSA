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
    Map<Integer, Integer> inMap = new HashMap<>();
    int preIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return build(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] pre, int[] in, int st, int end) {
        if(st > end) return null;

        int val = pre[preIdx++];
        TreeNode root = new TreeNode(val);
        int inIdx = inMap.get(val);

        root.left = build(pre, in, st, inIdx - 1);
        root.right = build(pre, in, inIdx + 1, end);

        return root;
    }
}