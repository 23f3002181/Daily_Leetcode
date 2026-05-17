class Solution {
    public boolean isBipartite(int[][] graph) {
        // BFS
        // int n = graph.length ;
        // int[] color = new int[n] ;
        // Arrays.fill(color , -1) ;
        // for(int start = 0 ; start < n ; start++){
        //     if(color[start] != -1) continue ;
        //     Queue<Integer> queue = new LinkedList<>() ;
        //     queue.offer(start) ;
        //     color[start] = 0 ;
        //     while(!queue.isEmpty()){
        //         int node = queue.poll() ;
        //         for(int neighbour : graph[node]){
        //             if(color[neighbour] == -1){
        //                 color[neighbour] = 1 - color[node] ;
        //                 queue.offer(neighbour) ;
        //             } else if(color[neighbour] == color[node]){
        //                 return false ;
        //             }
        //         }
        //     }
        // }
        // return true ;

        // DFS
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                color[i] = 0;
                if (!dfs(graph, color, i))
                    return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] color, int node) {
        for (int neighbour : graph[node]) {
            if (color[neighbour] == -1) {
                color[neighbour] = 1 - color[node];
                if (!dfs(graph, color, neighbour))
                    return false;
            } else if (color[neighbour] == color[node]) {
                return false;
            }
        }
        return true;
    }
}
