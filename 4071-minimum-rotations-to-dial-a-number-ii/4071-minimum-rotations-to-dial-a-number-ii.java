class Solution {
    public int minRotations(int n, String s) {
        char[] arr = s.toCharArray();
        int[] vals = new int[arr.length];
        int i = 0;
        for(i = 0;i<arr.length;i++) {
            vals[i] = arr[i]-'0';
        }
        int oldCost = -1;
        int newCost = -1;
        int diff =-1;
        int minDiff = Integer.MAX_VALUE;
        int minK = -1;
        for(int k = 0;k<arr.length;k++) {
            if(k == 0) {
                diff = Math.abs(0-vals[arr.length-1]);
                oldCost = Math.abs(0-vals[0]);
            } else {
                diff = Math.abs(vals[k-1] - vals[arr.length-1]);
                oldCost = Math.abs(vals[k] - vals[k-1]);
            }
            oldCost = Math.min(oldCost,10-oldCost);
            diff = Math.min(diff,10-diff);
            if(diff-oldCost < 0 && diff-oldCost < minDiff) {
                minDiff = diff-oldCost;
                minK = k;
            }
            
        }
        
        

        int ans = 0;
        int init = 0;
        for(i = 0;i<arr.length;i++) {
            diff = Math.abs(vals[i] - init);
            ans += Math.min(diff,10-diff);
            init = vals[i];
        }
        return ans + Math.min(0,minDiff);
    }
}