class Solution {
    public int firstMatchingIndex(String s) {
        int n = s.length();
        for(int i = 0;i<n;i++) {
            if(n-i-1 <0) break;

            if( s.charAt(i) == s.charAt(n-i-1)) return i;
        }

        return -1;
    }
}