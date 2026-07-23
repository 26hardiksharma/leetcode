class Solution {
    public int reverse(int x) {
        int neg = 1;

        if(x<0) {
            neg = -1;
            x = x*-1;
        }

        try {
            String s = Integer.toString(x);
            StringBuilder sb = new StringBuilder(s);
            s = sb.reverse().toString();
            return Integer.valueOf(s)*neg;
        } catch(Exception e) {
            return 0;
        }
    }
}