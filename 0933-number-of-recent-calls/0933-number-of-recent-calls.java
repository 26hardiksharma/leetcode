class RecentCounter {
    int counter;
    Queue<Integer> q = new LinkedList();
    public RecentCounter() {
        this.counter = 0;
    }
    
    public int ping(int t) {
        int lb = t-3000;
        int ub = t;
        q.offer(t);

        while(!q.isEmpty() && q.peek() <lb) {
            q.poll();
        }
        int count = 0;
        Queue<Integer> sync = new LinkedList<>();
        while(!q.isEmpty() && q.peek()<=ub) {
            count++;
            sync.offer(q.poll());
        }

        while(!q.isEmpty()) sync.offer(q.poll());
        q = sync;
        return count;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */