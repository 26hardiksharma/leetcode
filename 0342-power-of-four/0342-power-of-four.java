class Solution {
    public boolean isPowerOfFour(int n) {
        if(n == 1) return true;

        if(n<=3) return false;

        return (n & (n - 1)) == 0 && n%3 == 1;
    }
}