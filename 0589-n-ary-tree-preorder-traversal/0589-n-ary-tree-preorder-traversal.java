/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> out = new ArrayList<>();

    public void helper(Node root) {
        if(root == null) return;

        out.add(root.val);
        for(Node r: root.children) {
            helper(r);
        }
    }
    public List<Integer> preorder(Node root) {
        helper(root);
        return out;
    }
}