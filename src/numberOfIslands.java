
/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.
 */

public class numberOfIslands {

    private int n;
    private int m;

    public int numIslands(char [][] grid){

        int count = 0;
        n = grid.length;
        if(n == 0) return 0;
        m = grid[0].length;

        for(int i = 0; i < n; i++){
            for( int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    DFSMarking(grid, i, j);
                    ++count;
                    }
                }
            }
        return count;
    }

    private void DFSMarking(char[][] grid, int i, int j){

        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;

        grid[i][j] = '0';
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i -1, j);
        DFSMarking(grid, i, j + 1);
        DFSMarking(grid, i, j - 1);
    }

}
