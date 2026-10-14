class Bid implements Comparable<Bid> {
    int userId;
    int itemId;
    int bidAmount; 

    public Bid(int userId,int itemId,int bidAmount) {
        this.userId = userId;
        this.itemId = itemId;
        this.bidAmount = bidAmount;
    }

    public int compareTo(Bid b) {
        if(b.bidAmount != this.bidAmount) {
            return Integer.compare(b.bidAmount,this.bidAmount);
        }

        return Integer.compare(b.userId,this.userId);
    }
}

class AuctionSystem {
    HashMap<Integer,PriorityQueue<Bid>> bidMap = new HashMap<>();
    HashMap<Integer,HashMap<Integer,Integer>> bids = new HashMap<>();
    public AuctionSystem() {
    }
    
    public void addBid(int userId, int itemId, int bidAmount) {
        Bid bid = new Bid(userId,itemId,bidAmount);

        if(!bidMap.containsKey(itemId)) bidMap.put(itemId,new PriorityQueue<Bid>());
        
        if(!bids.containsKey(userId)){
            bids.put(userId,new HashMap<Integer,Integer>());
        }
        bids.get(userId).put(itemId,bidAmount);

        bidMap.get(itemId).offer(bid);
        
    }
    
    public void updateBid(int userId, int itemId, int newAmount) {

        if(!bids.containsKey(userId) || !bids.get(userId).containsKey(itemId)) return;
        bids.get(userId).put(itemId,newAmount);
        bidMap.get(itemId).offer(new Bid(userId,itemId,newAmount));
    }
    
    public void removeBid(int userId, int itemId) {

        if(!bids.containsKey(userId) || !bids.get(userId).containsKey(itemId)) return;
        
        bids.get(userId).remove(itemId);
    }
    
    public int getHighestBidder(int itemId) {
        PriorityQueue<Bid> pq = bidMap.get(itemId);

        if(pq == null || pq.size() == 0) return -1;

        while(!pq.isEmpty()) {
            Bid b = pq.peek();

            if(!bids.containsKey(b.userId) || !bids.get(b.userId).containsKey(b.itemId) || bids.get(b.userId).get(b.itemId) != b.bidAmount) {
                pq.poll();
                continue;
            }

            return b.userId;
        }

        return -1;
    }
}

/**
 * Your AuctionSystem object will be instantiated and called as such:
 * AuctionSystem obj = new AuctionSystem();
 * obj.addBid(userId,itemId,bidAmount);
 * obj.updateBid(userId,itemId,newAmount);
 * obj.removeBid(userId,itemId);
 * int param_4 = obj.getHighestBidder(itemId);
 */