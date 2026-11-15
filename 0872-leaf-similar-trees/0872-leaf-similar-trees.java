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

    public void helper(TreeNode root,ArrayList<Integer> l) {
        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null) {
            l.add(root.val);
            return;
        }

        helper(root.left,l);
        helper(root.right,l);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();

        helper(root1,l1);
        helper(root2,l2);

        int s1 = l1.size();
        int s2 = l2.size();

        if(s1 != s2) return false;

        for(int i = 0;i<s1;i++) {
            if(!l1.get(i).equals(l2.get(i))) return false;
        }

        return true;
    }
}