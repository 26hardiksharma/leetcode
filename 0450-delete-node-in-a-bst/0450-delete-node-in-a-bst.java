
class Solution {

    public TreeNode successor(TreeNode root) {
        if(root == null || root.left == null) {
            return root;
        }

        return successor(root.left);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }

        if(root.val == key) {

            if(root.left == null) {
                return root.right;
            }

            if(root.right == null) {
                return root.left;
            }

            TreeNode succ = successor(root.right);
            root.val = succ.val;
            root.right = deleteNode(root.right, succ.val);

        } else if(root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }
}
