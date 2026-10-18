class SmallestInfiniteSet {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    HashSet<Integer> set = new HashSet<>();
    public SmallestInfiniteSet() {
        for(int i = 1;i<=1000;i++) {
            set.add(i);
            pq.offer(i);
        }
    }
    
    public int popSmallest() {
        int p = pq.poll();
        set.remove(p);
        return p;
    }

    
    public void addBack(int num) {
        if(set.contains(num)) return;
        pq.offer(num);
        set.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */