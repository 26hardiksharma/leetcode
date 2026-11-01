class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean isInc = false;
        boolean isDec = false;
        for(int i = 1;i<nums.length;i++) {
            if(nums[i-1]<nums[i]) isInc = true;
            if(nums[i-1]>nums[i]) isDec = true;

            if(isInc == true && isDec == true) return false;

        }

        return true;
    }
}