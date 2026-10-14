class Event implements Comparable<Event>{
    int id;
    int priority;

    Event(int id,int priority) {
        this.id = id;
        this.priority = priority;

    }
    public int compareTo(Event r) {
        if(this.priority!= r.priority) {
            return Integer.compare(r.priority,this.priority);
        } 

        return Integer.compare(this.id,r.id);
    }
}
class EventManager {

    HashMap<Integer,Integer> map;
    PriorityQueue<Event> pq;
    public EventManager(int[][] events) {
        map = new HashMap<>();
        pq = new PriorityQueue<>();

        for(int[] i: events) {
            Event e = new Event(i[0],i[1]);
            pq.offer(e);
            map.put(i[0],i[1]);
        }
    }
    
    public void updatePriority(int eventId, int newPriority) {
        map.put(eventId,newPriority);
        pq.offer(new Event(eventId,newPriority));
    }
    
    public int pollHighest() {
        int id = -1;
        while(!pq.isEmpty()) {
            Event e =pq.poll();
            if(!map.containsKey(e.id) || e.priority != map.get(e.id)) continue;

            id = e.id;
            map.remove(e.id);
            break;
        }
        return id;
    }
}

/**
 * Your EventManager object will be instantiated and called as such:
 * EventManager obj = new EventManager(events);
 * obj.updatePriority(eventId,newPriority);
 * int param_2 = obj.pollHighest();
 */