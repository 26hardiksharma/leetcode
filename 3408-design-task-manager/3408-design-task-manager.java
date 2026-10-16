class TaskManager {

    HashMap<Integer,List<Integer>> map = new HashMap<>();
    PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> {
        int priorityDiff = Integer.compare(b.get(2), a.get(2));

        if (priorityDiff!= 0) {
            return priorityDiff;
        }

        return Integer.compare(b.get(1), a.get(1));
    });

    public TaskManager(List<List<Integer>> tasks) {
        for(List<Integer> l: tasks) {
            map.put(l.get(1),l);
            pq.add(l);
        }

    }
    
    public void add(int userId, int taskId, int priority) {
        List<Integer> l = Arrays.asList(new Integer[]{userId,taskId,priority});
        pq.offer(l);
        map.put(taskId,l);
    }
    
    public void edit(int taskId, int newPriority) {
        List<Integer> l = Arrays.asList(new Integer[]{map.get(taskId).get(0),taskId,newPriority});
        pq.offer(l);
        map.put(taskId,l);
    }
    
    public void rmv(int taskId) {
        map.remove(taskId);
    }
    
    public int execTop() {
        if(pq.isEmpty()) {
            return -1;
        }

        while(!pq.isEmpty()) {
            List<Integer> l = pq.poll();
            
            if(map.get(l.get(1))!= l) {
                continue;
            } else {
                map.remove(l.get(1));
                return l.get(0);
            }
        }
        return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */