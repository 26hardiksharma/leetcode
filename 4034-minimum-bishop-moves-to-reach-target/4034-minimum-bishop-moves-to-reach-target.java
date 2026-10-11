class Solution {
    public int minBishopMoves(int[] source, int[] target) {
        char sq = 'a';
        char tq = 'a';

        if((target[0]%2 == 0 && target[1]%2 == 0) || (target[0]%2 == 1 && target[1]%2 == 1)) {
            tq = 'b';
        } else {
            tq = 'w';
        }

        if((source[0]%2 == 0 && source[1]%2 == 0) || (source[0]%2 == 1 && source[1]%2 == 1)) {
            sq = 'b';
        } else {
            sq = 'w';
        }

        if(tq != sq) return -1;

        if(source[0] == target[0] && source[1] == target[1]) return 0;

        if(Math.abs((source[0]-target[0])) == Math.abs(source[1]-target[1])) {
            return 1;
        }

        return 2;


    }
}