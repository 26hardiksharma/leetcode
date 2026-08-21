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
    static boolean isBalanced = true;
    public int height(TreeNode root) {
        if(!isBalanced) {
            return 0;
        }

        if( root == null) return 0;
        
        if(root.left == null && root.right == null) {
            return 1;
        }
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if(Math.abs(leftHeight-rightHeight)>1) {
            isBalanced = false;
        }
        return Math.max(leftHeight,rightHeight)+1;
    }

    public boolean isBalanced(TreeNode root) {
        int x = height(root);
        boolean ans = isBalanced;
        isBalanced = true;
        return ans;
    }
}