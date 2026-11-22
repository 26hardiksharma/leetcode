class Solution {
    public boolean checkString(String s) {
        int a =0;
        int b =0;
        int len = s.length();
        for(int i = 0;i<len;i++) {
            if(s.charAt(i) == 'a' && b > 0) return false;

            if(s.charAt(i) == 'b') b++;


        }

        return true;
    }
}