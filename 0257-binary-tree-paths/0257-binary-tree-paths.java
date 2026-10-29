
class Solution {
    List<String> l = new ArrayList<>();

    public void helper(TreeNode root, String s) {
        if (root == null) return;

        if (s.equals("")) {
            s = "" + root.val;
        } else {
            s += "->" + root.val;
        }

        if (root.left == null && root.right == null) {
            l.add(s);
            return;
        }

        helper(root.left, s);
        helper(root.right, s);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        helper(root, "");
        return l;
    }
}
