class KthLargest {
    int k;
    List<Integer> l = new ArrayList<>();
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i:nums) {
            l.add(i);
        }
        Collections.sort(l);
    }

    public int add(int val) {
        l.add(val);
        Collections.sort(l);

        return l.get(l.size()-k);
        
            
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */