class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet dsu = new DisjointSet(n) ;
        int[] res = new int[2];
        for (int[] edge : edges) {
            if (!dsu.UnionBySize(edge[0] - 1, edge[1] - 1)) {
                res = edge;
            }
        }
        return res;
    }
}

public class DisjointSet {
    int[] parent;
    int[] size;

    DisjointSet(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findUPar(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = findUPar(parent[node]);
    }

    public boolean UnionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v)
            return false;
        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
        return true;
    }
}
