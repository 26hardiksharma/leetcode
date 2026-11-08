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
    List<Integer> l = new ArrayList<>();

    public void inorder(TreeNode root) {
        if(root == null) return;

        inorder(root.left);
        l.add(root.val);
        inorder(root.right);

    }
    public int minDiffInBST(TreeNode root) {
        inorder(root);
        int minDiff = Integer.MAX_VALUE;
        int i = 0;
        int j = 1;
        int size = l.size();
        while(j<size) {
            minDiff = Math.min(minDiff,Math.abs(l.get(j)-l.get(i)));
            i++;
            j++;
        }
        return minDiff;
    }
}