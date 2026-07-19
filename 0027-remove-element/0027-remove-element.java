class Solution {
    public int removeElement(int[] nums, int val) {
        int p1 = 0;
        int p2 = nums.length -1;

        ArrayList<Integer> l = new ArrayList<>();

        for(int i:nums) {
            if(i != val)  l.add(i);
        }
        int idx = 0;
        for(int i:l) {
            nums[idx++] = i;
        }

        return l.size();
    }
}