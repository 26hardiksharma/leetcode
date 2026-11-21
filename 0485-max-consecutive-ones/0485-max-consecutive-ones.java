class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i = 0;
        int j =0;

        int count = 0;

        while(j<nums.length) {
            if(nums[j]!=1) {
                count = Math.max(count,j-i);
                i=j+1;
            } 
            j++;
        }

        return Math.max(count,j-i);
    }
}