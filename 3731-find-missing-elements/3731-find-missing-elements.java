class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        if(nums.length == 0) return ret;
        HashSet<Integer> m = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<nums.length;i++) {
            m.add(nums[i]);  
            if(nums[i]<min) min = nums[i];
            if(nums[i]>max) max = nums[i];
        }

        for(int i = min;i<max;i++) {
            if(!m.contains(i)) {
                ret.add(i);
            }
        }

        return ret;
    }
}