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
    public int helper(TreeNode root, int low, int high) {
        if(root == null) return 0;
        int s = 0;
        if(root.val <low) {
            return s + helper(root.right,low,high);
        } else if(root.val > high) {
            return s + helper(root.left,low,high);
        } else {
            return root.val + helper(root.left,low,high) + helper(root.right,low,high);
        } 

    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        return helper(root,low,high);
    }
}