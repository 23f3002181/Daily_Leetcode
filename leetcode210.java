class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>() ;
        for(int i = 0 ; i < numCourses ; i++){
            graph.add(new ArrayList<>()) ;
        }
        int[] indegree = new int[numCourses] ;
        for(int[] pre : prerequisites){
            int a = pre[0] ;
            int b = pre[1] ;
            graph.get(b).add(a) ;
            indegree[a]++ ;
        }
        Queue<Integer> q = new LinkedList<>() ;
        for(int i = 0 ; i < numCourses ; i++){
            if(indegree[i] == 0){
                q.offer(i) ;
            } 
        }
        int[] topoSort = new int[numCourses] ;
        int i = 0 ;
        while(!q.isEmpty()){
            int node = q.poll() ;
            topoSort[i++] = node ;
            for(int neighbour : graph.get(node)){
                indegree[neighbour]-- ;
                if(indegree[neighbour] == 0){
                    q.offer(neighbour) ;
                }
            }
        }
        if(i == numCourses){
            return topoSort ;
        } else {
            return new int[]{} ;
        }
    }
}
