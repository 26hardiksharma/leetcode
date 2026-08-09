class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x == 1) return x;
        long k = (long) x;
        for(long i =0;i<k;i++) {
            if(i*i == k) {
                return (int) i;
            }

            if(i*i<x && (i+1)*(i+1) > x) {
                return (int) i;
            }
        }

        return -1;


    }
}