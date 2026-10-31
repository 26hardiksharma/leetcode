class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        HashSet<Integer> set = new HashSet<>();
        for(int i:nums) {
            if(!set.contains(i)) {
                pq.offer(i);
                set.add(i);
            }
        }
        if(pq.size()<3) {
            return pq.poll();
        }
        pq.poll();
        pq.poll();

        return pq.poll();
    }
}