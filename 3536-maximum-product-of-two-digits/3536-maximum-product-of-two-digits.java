class Solution {
    public int maxProduct(int n) {
        int x = -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        while(n!=0) {
            x = n%10;
            n=n/10;

            pq.offer(x);
        }

        return pq.poll()*pq.poll();
    }
}