class Solution {
    private static final int[][] directions = {{0,-1},{0,1},{-1,0},{1,0}} ;

    public int numIslands(char[][] grid) {
        int rows = grid.length ;
        int cols = grid[0].length ;
        boolean[][] visited = new boolean[rows][cols] ;
        int islands = 0 ;
        for(int r = 0 ; r < rows ; r++){
            for(int c = 0 ; c < cols ; c++){
                if(grid[r][c] == '1' && !visited[r][c]){
                    islands++ ; 
                    bfs(grid,r,c,visited) ;
                }
            }
        }
        return islands ;
    }

    private void bfs(char[][] grid , int r , int c , boolean[][] visited){
        Queue<int[]> q = new LinkedList<>() ;
        q.offer(new int[]{r,c}) ;
        visited[r][c] = true ;
        while(!q.isEmpty()){
            int[] curr = q.poll() ;
            int row = curr[0] ;
            int col = curr[1] ;
            for(int[] dir : directions){
                int nr = row + dir[0];
                int nc = col + dir[1];
                if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == '1' && !visited[nr][nc]){
                    q.offer(new int[]{nr,nc}) ;
                    visited[nr][nc] = true ;
                }
            }
        }
    }
}
