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
    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        int size = l.size();
        TreeNode head = new TreeNode(l.get(0));
        TreeNode curr = head;
        for(int i = 1;i<size;i++) {
            curr.right = new TreeNode(l.get(i));
            curr =curr.right;
        }
        return head;
    }
}