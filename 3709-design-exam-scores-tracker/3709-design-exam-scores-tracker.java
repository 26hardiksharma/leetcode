class ExamTracker {
    ArrayList<Integer> times;
    ArrayList<Long> prefix;

    public ExamTracker() {
        times = new ArrayList<>();    
        prefix= new ArrayList<>();  
        prefix.add(0L);  
    }
    
    public void record(int time, int score) {
        times.add(time);
        prefix.add(score + prefix.get(prefix.size()-1));
    }
    
    public long totalScore(int startTime, int endTime) {
        int size = times.size();
        int low = 0;
        int high = size;
        int mid = -1;
        while(low<high) {
            mid = low+ (high-low)/2;

            if(times.get(mid)<startTime) {
                low = mid+1;
            } else {
                high = mid;
            }
        }

        int firstIdx = low;
        low = 0;
        high = size;

        while(low<high) {
            mid = low + (high-low)/2;

            if(times.get(mid)<=endTime) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return prefix.get(low) - prefix.get(firstIdx);

    }
}

/**
 * Your ExamTracker object will be instantiated and called as such:
 * ExamTracker obj = new ExamTracker();
 * obj.record(time,score);
 * long param_2 = obj.totalScore(startTime,endTime);
 */