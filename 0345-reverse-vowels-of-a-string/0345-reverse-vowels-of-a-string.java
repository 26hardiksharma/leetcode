class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> set = new HashSet<>();
        char[] arr = {'a','e','i','o','u','A','E','I','O','U'};
        for(char c: arr) {
            set.add(c);
        }

        Stack<Character> stack = new Stack();
        char[] str = s.toCharArray();
        for(char ch:str) {
            if(set.contains(ch)) stack.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<s.length();i++) {
            if(set.contains(s.charAt(i))) {
                sb.append(stack.pop());
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}