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
    public int findMax(TreeNode root) {
        if(root == null) return 0;

        return 1 + Math.max(findMax(root.left), findMax(root.right));
    }
    public int traverse(TreeNode root,int level,int maxLevel) {
        if(root == null) return 0;

        if(root.left == null && root.right == null && level == maxLevel) {
            return root.val;
        }

        return traverse(root.left,level+1,maxLevel) + traverse(root.right,level+1,maxLevel);
    }
    public int deepestLeavesSum(TreeNode root) {
        int maxDepth = findMax(root);
        System.out.println(maxDepth);
        return traverse(root,1,maxDepth);
    }
}