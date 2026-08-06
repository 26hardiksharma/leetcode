class Solution {
    public static int product(int n) {
        int prod = 1;
        while(n>0) {
            int rem = n%10;
            if(rem == 0) return 0;

            prod*=rem;
            n/=10;
        }

        return prod;
    }
    public int smallestNumber(int n, int t) {
        while(true) {
            if(product(n)%t == 0) return n;
            n++;
        }

    }
}