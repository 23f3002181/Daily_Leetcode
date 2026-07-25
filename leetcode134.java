class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSurplus = 0;
        int currentSurplus = 0;
        int start = 0;
        
        for (int i = 0; i < gas.length; i++) {
            int net = gas[i] - cost[i];
            totalSurplus += net;
            currentSurplus += net;
            
            if (currentSurplus < 0) {
                currentSurplus = 0;
                start = i + 1;
            }
        }
        
        return totalSurplus < 0 ? -1 : start;
    }
}
