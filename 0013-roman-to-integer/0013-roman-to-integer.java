class Solution {
    static HashMap<Character,Integer> map = new HashMap<>();

    public void init() {
        if(!map.isEmpty()) return;
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
    }
    public int romanToInt(String s) {
        init();
        int num = map.get(s.charAt(s.length()-1));
        for(int i = s.length()-2;i>=0;i--) {
            int n = map.get(s.charAt(i));

            if(n>=map.get(s.charAt(i+1))) {
                num+=n;
            } else {
                num-=n;
            }
        }
        return num;
    }
}