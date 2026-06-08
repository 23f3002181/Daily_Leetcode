class Pair {
    int wt;
    int node;

    Pair(int node, int wt) {
        this.node = node;
        this.wt = wt;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            adj.get(u).add(new Pair(v, w));
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        minHeap.offer(new Pair(k, 0));
        while (!minHeap.isEmpty()) {
            Pair curr = minHeap.poll();
            int node = curr.node;
            int wt = curr.wt;
            if (wt > dist[node])
                continue;
            for (Pair neigh : adj.get(node)) {
                int adjNode = neigh.node;
                int adjWt = neigh.wt;
                if (wt + adjWt < dist[adjNode]) {
                    dist[adjNode] = wt + adjWt;
                    minHeap.offer(new Pair(adjNode, dist[adjNode]));
                }
            }
        }
        int res = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                return -1;
            res = Math.max(res, dist[i]);
        }

        return res;
    }
}
