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
    int maxDepth = Integer.MIN_VALUE;
    public void helper(Node root, int cur) {
        if(root == null) return;

        if(root.children == null || root.children.size() == 0) {
            maxDepth = Math.max(maxDepth,cur);
            return;
        }

        for(Node n: root.children) {
            helper(n,cur+1);
        }
    }
    public int maxDepth(Node root) {
        if(root == null) return 0;
        helper(root,1);
        return maxDepth;
    }
}