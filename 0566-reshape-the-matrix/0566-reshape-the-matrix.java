class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int n = mat.length;
        int m = mat[0].length;

        if(r == n && c == m || r*c != m*n) {
            return mat;
        }

        int[][] newMat = new int[r][c];
        Queue<Integer> q =new LinkedList<>();
        for(int[] i: mat) {
            for(int j:i) {
                q.offer(j);
            }
        }
        int i =0;
        int j = 0;
        while(!q.isEmpty()) {
            newMat[i][j] = q.poll();
            j++;
            if(j == c) {
                j = 0;
                i++;
            }
        }
        return newMat;
    }
}