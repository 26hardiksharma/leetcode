class Solution {
    public int minRotations(String s) {
        char[] arr = s.toCharArray();
        int[] vals = new int[10];
        int i = 0;
        for(i = 0;i<10;i++) {
            vals[i] = arr[i]-'0';
        }

        int ans = 0;
        int init = 0;
        for(i = 0;i<10;i++) {
            int diff = Math.abs(vals[i] - init);
            ans += Math.min(diff,10-diff);
            init = vals[i];
        }
        return ans;
    }
}