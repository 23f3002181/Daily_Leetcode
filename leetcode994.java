class Node {
    int row ;
    int col ;
    int time ;

    Node(int row , int col , int time){
        this.row = row ;
        this.col = col ;
        this.time = time ;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Node> queue = new LinkedList<>();
        int m = grid.length ;
        int n = grid[0].length ;

        int fresh = 0 ;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 2){
                    queue.offer(new Node(i,j,0)) ;
                }
                if(grid[i][j] == 1){
                    fresh++ ;
                }
            }
        }
        int minutes = 0 ;
        int[] drow = {-1,1,0,0} ; // UP DOWN LEFT RIGHT
        int[] dcol = {0,0,-1,1} ;
        while(!queue.isEmpty() && fresh > 0){
            Node curr = queue.poll();
            int r = curr.row ;
            int c = curr.col ;
            int t = curr.time ;
            for(int i = 0 ; i < 4 ; i++){
                int nr = r + drow[i] ;
                int nc = c + dcol[i] ;
                if(nr >= 0 && nr < m && nc >=0 && nc < n && grid[nr][nc] == 1){
                    grid[nr][nc] = 2 ;
                    fresh-- ;
                    minutes = t + 1;
                    queue.offer(new Node(nr,nc,t + 1)) ;
                }
            }
        }
        if(fresh == 0){
            return minutes ;
        } else{
            return -1 ;
        }        
    }
}
