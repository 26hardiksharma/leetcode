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

    public static void traverse(TreeNode root, ArrayList<Integer> l) {
        if(root == null) return;

        traverse(root.left,l);
        l.add(root.val);
        traverse(root.right,l);
    }
    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> l = new ArrayList<>();

        traverse(root,l);

        int minDiff = Integer.MAX_VALUE;

        int size = l.size();

        for(int i = 1;i<size;i++) {
            minDiff = Math.min(minDiff,l.get(i)- l.get(i-1));

        }

        return minDiff;
    }
}