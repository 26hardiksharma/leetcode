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
    int minDepth = Integer.MAX_VALUE;
    public void helper(TreeNode root,int curr) {
        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null) {
            minDepth = Math.min(minDepth,curr);
            return;
        }

        helper(root.left,curr+1);
        helper(root.right,curr+1);
    }
    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        helper(root,1);
        return minDepth;
    }
}