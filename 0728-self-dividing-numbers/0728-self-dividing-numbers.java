class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> l = new ArrayList<>();

        for(int i = left;i<=right;i++) {
            char[] arr = Integer.toString(i).toCharArray();
            boolean flag = true;
            for(char ch: arr) {
                if(ch -'0' == 0 || i%(ch-'0') != 0) {
                    flag = false;
                    break;
                }
            }

            if(flag) l.add(i);
        }
        return l;
    }
    
}