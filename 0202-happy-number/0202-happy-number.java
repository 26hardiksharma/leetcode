class Solution {
    public int digitSquareSum(int n) {
        int sum = 0;
        while(n != 0) {
            int k = n%10;
            sum+= k*k;
            n = n/10;
        }

        return sum;
    }
    public boolean isHappy(int n) {
        if(n == 1) return true;

        int copy = n;
        HashSet<Integer> s = new HashSet<>();
        while(true) {
            n = digitSquareSum(n);
            if (n == copy || s.contains(n)) return false;
            if(n == 1) return true;
            s.add(n);
        }
    }
}