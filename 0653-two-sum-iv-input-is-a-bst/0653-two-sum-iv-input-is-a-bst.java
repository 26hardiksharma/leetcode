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
    public ArrayList<Integer> arr= new ArrayList<>();

    public void traverse(TreeNode root) {
        if(root == null) {
            return;
        }
        traverse(root.left);
        arr.add(root.val);
        traverse(root.right);
    }
    public boolean findTarget(TreeNode root, int k) {
        traverse(root);
        int i = 0,j=arr.size()-1;
        for(int x:arr) {
            System.out.print(x + " ");
        }
        while(i<j) {
            if(arr.get(i)+arr.get(j) == k) {
                return true;
            } else if(arr.get(i)+arr.get(j)>k) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }
}