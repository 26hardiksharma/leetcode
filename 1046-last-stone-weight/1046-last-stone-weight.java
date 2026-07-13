class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue(Comparator.reverseOrder());
        for(int i:stones) {
            pq.offer(i);
        }
        while(!pq.isEmpty()) {
            if(pq.size() == 1) {
                return pq.poll();
            } else {
                int s1 = pq.poll();
                int s2 = pq.poll();

                if(s1 != s2) {
                    // System.out.println(s1 + " + " + s2);
                    pq.offer(s1-s2);
                }
            }
        }

        return 0;
    }
}