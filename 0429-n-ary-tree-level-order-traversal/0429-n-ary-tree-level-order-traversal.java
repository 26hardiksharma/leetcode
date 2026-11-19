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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            List<Integer> cur = new ArrayList<>();
            int size = q.size();
            for(int i = 0;i<size;i++) {
                Node curr = q.poll();
                cur.add(curr.val);
                for(Node n: curr.children) {
                    if(n != null) q.offer(n);
                }
                
            }
            ans.add(cur);
        }
        return ans;
    }
}