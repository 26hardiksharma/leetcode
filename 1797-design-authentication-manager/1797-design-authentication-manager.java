class AuthenticationManager {
    int timeToLive;
    HashMap<String,Integer> map = new HashMap<>();
    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;       
    }
    
    public void generate(String tokenId, int currentTime) {
        map.put(tokenId,currentTime);
    }
    
    public void renew(String tokenId, int currentTime) {
        if(!map.containsKey(tokenId)) return;
        int time = map.get(tokenId);
        if(time+timeToLive<=currentTime) return;
        map.put(tokenId,currentTime);
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (String key : map.keySet()) {
            int time = map.get(key);
            if(time + timeToLive>currentTime) count++;
        }
        return count;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */