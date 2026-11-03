class Solution {
    static boolean initialized = false;

    static HashSet<Character> first = new HashSet<>();
    static HashSet<Character> second = new HashSet<>();
    static HashSet<Character> third = new HashSet<>();

    public void init() {
        if(initialized) return;

        char[] firstRow = "qwertyuiop".toCharArray();
        char[] secondRow= "asdfghjkl".toCharArray();
        char[] thirdRow= "zxcvbnm".toCharArray();

        for(char ch: firstRow) {
            first.add(ch);
        }
        for(char ch: secondRow) {
            second.add(ch);
        }
        for(char ch: thirdRow) {
            third.add(ch);
        }

        initialized = true;
    }
    public String[] findWords(String[] words) {
        init();
        List<String> s= new ArrayList<>();
        for(String word: words) {
            String copy = word;
            word = word.toLowerCase();
            HashSet<Character> row = null;
            char[] arr = word.toCharArray();
            if(first.contains(arr[0])){
                row = first;
            } else if(second.contains(arr[0])) {
                row = second;
            } else {
                row = third;
            }
            
            boolean flag = true;
            for(char ch: arr) {
                if(!row.contains(ch)) {
                    flag = false;
                    break;
                }
            }
            if(flag == true) s.add(copy);

        }
        String[] out = new String[s.size()];
        int i = 0;
        for(String k:s) {
            out[i++]= k;
        }

        return out;
    }

}