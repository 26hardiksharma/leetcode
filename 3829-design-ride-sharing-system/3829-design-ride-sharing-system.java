class RideSharingSystem {
    Queue<Integer> riders = new LinkedList<>();
    Queue<Integer> drivers = new LinkedList<>();
    HashSet<Integer> live = new HashSet<>();
    HashSet<Integer> stale = new HashSet<>();
    public RideSharingSystem() {
        
    }
    
    public void addRider(int riderId) {
        riders.offer(riderId);
        live.add(riderId);
        stale.remove(riderId);
    }
    
    public void addDriver(int driverId) {
        drivers.offer(driverId);
    }
    
    public int[] matchDriverWithRider() {
        if(riders.isEmpty() || drivers.isEmpty()) return new int[] {-1,-1};
        while(!riders.isEmpty()) {
            int riderId = riders.peek();
            if(stale.contains(riderId)) {
                riders.poll();
            } else {
                break;
            }
        }
        if(riders.isEmpty()) {
            return new int[] {-1,-1};
        }
        live.remove(riders.peek());
        return new int[] {drivers.poll(),riders.poll()};

    }
    
    public void cancelRider(int riderId) {
        if(!live.contains(riderId)) return;

        stale.add(riderId);
    }
}

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem obj = new RideSharingSystem();
 * obj.addRider(riderId);
 * obj.addDriver(driverId);
 * int[] param_3 = obj.matchDriverWithRider();
 * obj.cancelRider(riderId);
 */