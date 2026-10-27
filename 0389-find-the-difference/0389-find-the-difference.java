class Solution {
    public char findTheDifference(String s, String t) {
        int s1 = 0;
        int s2 = 0;

        for(char c: s.toCharArray()) {
            s1+= (int)c;
        }
        for(char c: t.toCharArray()) {
            s2 += (int)c;
        }

        return (char) (s2-s1);

    }
}