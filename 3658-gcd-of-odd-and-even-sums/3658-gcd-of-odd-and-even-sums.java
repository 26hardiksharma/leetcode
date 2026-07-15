class Solution {
    public static int getGCD(int a, int b) {
        return b == 0 ? a : getGCD(b, a % b);
    }   
    public int gcdOfOddEvenSums(int n) {
        int oddSum = n*n;
        int evenSum = oddSum+n;

        return getGCD(oddSum,evenSum);
    }
}