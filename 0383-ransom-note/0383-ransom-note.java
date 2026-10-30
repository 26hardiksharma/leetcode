class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] s1 = new int[26];
        int[] s2 = new int[26];

        for(int i = 0;i<ransomNote.length();i++) {
            s1[ransomNote.charAt(i)-'a']++;
        }
        for(int i = 0;i<magazine.length();i++) {
            s2[magazine.charAt(i)-'a']++;
        }

        for(int i = 0;i<26;i++) {
            if(s1[i] >s2[i]) {
                return false;
            }
        }

        return true;
    }
}