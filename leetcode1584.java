class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int minCost = 0;
        int edgesConnected = 0;
        int[] minDist = new int[n];
        boolean[] inMST = new boolean[n];
        for (int i = 0; i < n; i++) {
            minDist[i] = Integer.MAX_VALUE;
        }
        minDist[0] = 0;
        while (edgesConnected < n) {
            int currMinEdge = Integer.MAX_VALUE;
            int currNode = -1;
            for (int i = 0; i < n; i++) {
                if (!inMST[i] && minDist[i] < currMinEdge) {
                    currMinEdge = minDist[i];
                    currNode = i;
                }
            }
            minCost += currMinEdge;
            edgesConnected++;
            inMST[currNode] = true;
            for (int nextNode = 0; nextNode < n; nextNode++) {
                if (!inMST[nextNode]) {
                    int weight = Math.abs(points[currNode][0] - points[nextNode][0]) 
                               + Math.abs(points[currNode][1] - points[nextNode][1]);
                    if (weight < minDist[nextNode]) {
                        minDist[nextNode] = weight;
                    }
                }
            }
        }
        
        return minCost;
    }
}
