class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        int count = 0 ;
        while(!q.isEmpty()){
            int node = q.poll() ;
            count++ ;
            for(int neighbour : graph.get(node)){
                indegree[neighbour]-- ;
                if(indegree[neighbour] == 0){
                    q.offer(neighbour) ;
                }
            }
        }
        return count == numCourses ;
    }
}
