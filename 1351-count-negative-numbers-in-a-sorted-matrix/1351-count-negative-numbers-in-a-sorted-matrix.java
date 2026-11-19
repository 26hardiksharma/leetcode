class Solution {
    public int countNegatives(int[][] grid) {
        int i = 0;
        int j = grid[0].length -1;
        int c = 0;
        while(i<grid.length) {
            while(j >=0 && grid[i][j]<0) {
                c++;
                j--;
            }

            j = grid[0].length -1;
            i++;
        }

        return c;
    }
}