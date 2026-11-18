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
    int val = 0;
    public void helper(TreeNode root,String s) {
        if(root == null) return;
        
        if(root.left == null && root.right == null) {
            val += Integer.parseInt(s+root.val, 2);
            return;
        }

        helper(root.left,s + Integer.toString(root.val));
        helper(root.right,s + Integer.toString(root.val));

    }
    public int sumRootToLeaf(TreeNode root) {
        helper(root,"");
        return val;
    }
}