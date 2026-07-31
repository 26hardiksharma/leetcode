class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        int idx = 0;
        int failed = 0;
        for(int i:students) {
            q.offer(i);
        }
        int size = sandwiches.length;

        while(!q.isEmpty() && q.size() >failed) {

            int curr = q.poll();
            if(curr == sandwiches[idx]) {
                idx++;
                failed =0;
            } else {
                q.offer(curr);
                failed++;
            }
        }

        return failed;
    }
}