class Solution {

    private int timer = 1;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for(List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] tin = new int[n];
        int[] low = new int[n];
        boolean[] visited = new boolean[n];

        List<List<Integer>> bridges = new ArrayList<>();

        dfs(0, -1, adj, visited, tin, low, bridges);

        return bridges;
    }

    private void dfs(int node,
                     int parent,
                     List<List<Integer>> adj,
                     boolean[] visited,
                     int[] tin,
                     int[] low,
                     List<List<Integer>> bridges) {

        visited[node] = true;

        tin[node] = low[node] = timer;
        timer++;

        for(int adjNode : adj.get(node)) {

            // ignore parent edge
            if(adjNode == parent) continue;

            // back edge
            if(visited[adjNode]) {
                low[node] = Math.min(low[node], tin[adjNode]);
            }
            else {

                dfs(adjNode, node, adj, visited, tin, low, bridges);

                low[node] = Math.min(low[node], low[adjNode]);

                // bridge condition
                if(low[adjNode] > tin[node]) {
                    bridges.add(Arrays.asList(node, adjNode));
                }
            }
        }
    }
}
