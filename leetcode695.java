class Solution {
    private static final int[][] directions = {{0,-1},{-1,0},{0,1},{1,0}} ; // LEFT UP RIGHT DOWN

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length ; 
        int cols = grid[0].length ;
        int area = 0 ;
        for(int r = 0 ; r < rows ; r++){
            for(int c = 0 ; c < cols ; c++){
                if(grid[r][c] == 1){
                    area = Math.max(area, bfs(grid,r,c)) ;
                }
            }
        }
        return area ;
    }

    private int bfs(int[][] grid, int r, int c){
        Queue<int[]> q = new LinkedList<>() ;
        grid[r][c] = 0 ;
        q.offer(new int[]{r,c}) ;
        int res = 1 ;
        while(!q.isEmpty()){
            int[] curr = q.poll() ;
            int row = curr[0] ;
            int col = curr[1] ;
            for(int[] dir : directions){
                int nr = row + dir[0] ;
                int nc = col + dir[1] ;
                if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1){
                    q.offer(new int[]{nr,nc}) ;
                    grid[nr][nc] = 0 ;
                    res++ ;
                }
            }
        }
        return res ;
    }
}
