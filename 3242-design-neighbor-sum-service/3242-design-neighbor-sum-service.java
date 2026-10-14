class Pair {
    int x;
    int y;

    Pair(int x,int y) {
        this.x = x;
        this.y = y;
    }
}
class NeighborSum {
    int[][] grid;
    HashMap<Integer,Pair> map= new HashMap<>();
    public NeighborSum(int[][] grid) {
        this.grid = grid;

        for(int i = 0;i<grid.length;i++) {
            for(int j = 0;j<grid.length;j++) {
                map.put(grid[i][j],new Pair(i,j));
            }
        }
    }
    
    public int adjacentSum(int value) {
        Pair p = map.get(value);
        int x = p.x;
        int y = p.y;

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        int sum = 0;

        for(int i = 0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>= 0 && ny>= 0 && nx<grid.length && ny<grid.length) {
                sum+=grid[nx][ny];
            }
        }

        return sum;
    }
    
    public int diagonalSum(int value) {
        Pair p = map.get(value);
        int x = p.x;
        int y = p.y;

        int[] dx = {-1,1,-1,1};
        int[] dy = {-1,-1,1,1};

        int sum = 0;

        for(int i = 0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>= 0 && ny>= 0 && nx<grid.length && ny<grid.length) {
                sum+=grid[nx][ny];
            }
        }

        return sum;
    }
}

/**
 * Your NeighborSum object will be instantiated and called as such:
 * NeighborSum obj = new NeighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */