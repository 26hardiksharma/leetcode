class Packet {
    int source;
    int destination;
    int timestamp;

    public String address() {
        return source+"#"+destination+"#"+timestamp;
    }
    Packet(int src,int dest,int timestamp) {
        this.source = src;
        this.destination = dest;
        this.timestamp = timestamp;
    }

    

}
class Router {
    int memoryLimit;
    Deque<Packet> queue;
    HashSet<String> map = new HashSet<>();
    HashMap<Integer,ArrayList<Integer>> timestamps= new HashMap<>();
    HashMap<Integer,Integer> indices = new HashMap<>();
    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        queue= new ArrayDeque<>();
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
        Packet packet = new Packet(source,destination,timestamp);
        String address = packet.address();
        if(map.contains(address)) {
            return false;
        }
        indices.putIfAbsent(destination, 0);
        if(queue.size() == memoryLimit) {
            Packet rem = queue.removeFirst();
            map.remove(rem.address());
            int dest = rem.destination;
            indices.put(dest,indices.getOrDefault(dest,0)+1);

        }
        map.add(address);
        if(!timestamps.containsKey(destination)) {
            ArrayList<Integer> l = new ArrayList<>();
            l.add(timestamp);
            timestamps.put(destination,l);
        } else {
            ArrayList<Integer> l = timestamps.get(destination);
            l.add(timestamp);
        }

        queue.addLast(packet);
        return true;
    }
    
    public int[] forwardPacket() {
        if(queue.size() == 0) {
            return new int[] {};
        } 

        Packet p = queue.removeFirst();
        map.remove(p.address());
        indices.put(p.destination, indices.getOrDefault(p.destination, 0) + 1);
        return new int[] {p.source,p.destination,p.timestamp};
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        int count = 0;
        if(!timestamps.containsKey(destination)) {
            return 0;
        }

        ArrayList<Integer> l = timestamps.get(destination);
        int index = indices.getOrDefault(destination,0);

        int low = index;
        int size = l.size();
        int high = size;
        int mid = -1;
        int firstIdx = -1;
        while(low<high) {
            mid = low + (high-low)/2;
            if(l.get(mid)<startTime) {
                low = mid+1;
            } else {
                high = mid;
            }
        }

        firstIdx = low;

        high = size;

        while(low<high) {
            mid = low + (high-low)/2;
            if(l.get(mid)>endTime) {
                high=mid; 
            } else {
                low = mid+1;
            }
        }

        return low-firstIdx;



    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */