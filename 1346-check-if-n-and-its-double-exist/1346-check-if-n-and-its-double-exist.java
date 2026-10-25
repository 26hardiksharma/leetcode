class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> s = new HashSet<>();

        for(int i: arr) {

            if(s.contains(i*2)) return true;

            if(i%2 == 0 && s.contains(i/2)) return true;

            s.add(i);
        }

        return false;
    }
}