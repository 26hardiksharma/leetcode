
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> out = new ArrayList<>();

        if (root == null) return out;

        Queue<TreeNode> q = new LinkedList<>();
        Stack<List<Integer>> s = new Stack<>();

        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                level.add(curr.val);

                if (curr.left != null) {
                    q.offer(curr.left);
                }

                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }

            s.push(level);
        }

        while (!s.isEmpty()) {
            out.add(s.pop());
        }

        return out;
    }
}
