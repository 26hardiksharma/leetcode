class Solution {
    public int removeDuplicates(int[] nums) {
        LinkedHashMap<Integer,Integer> map= new LinkedHashMap<>();
        for(int i:nums) {
            if(map.containsKey(i)) {
                if(map.get(i)<2) {
                    map.put(i,map.get(i)+1);
                } 
            } else {
                map.put(i,1);
            }
        }
        int count = 0;
        int x = 0;
        for(int i:map.keySet()) {
            for(int itr = 0;itr<map.get(i);itr++) {
                nums[x++] = i; 
                count++;
            }
        }
        return count;
        
    }
}