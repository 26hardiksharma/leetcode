class Solution {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        int l = s.length();
        for(int i = 0;i<l;i++) {
            arr[s.charAt(i)-'a']++;
        }  
        for(int i = 0;i<l;i++) {
            char ch = s.charAt(i);
            if(arr[ch-'a'] == 1) {
                return i;
            }
        }

        return -1;


    }
}