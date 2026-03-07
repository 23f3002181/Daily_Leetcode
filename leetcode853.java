class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }
        Arrays.sort(pairs, (a,b) -> Integer.compare(b[0], a[0]));
        int fleets = 1;
        double prev_time = (double)(target - pairs[0][0]) / pairs[0][1];
        for(int i = 0; i < n; i++){
            double curr_time = (double)(target - pairs[i][0]) / pairs[i][1];
            if(curr_time > prev_time){
                fleets ++;
                prev_time = curr_time;
            }
        }
        return fleets;

        // int[][] pairs = new int[position.length][2];
        // for (int i = 0; i < position.length; i++) {
        //     pairs[i][0] = position[i];
        //     pairs[i][1] = speed[i];
        // }
        // Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));
        // Stack<Double> stack = new Stack<>();
        // for (int[] p : pairs) {
        //     stack.push((double) (target - p[0]) / p[1]);
        //     if (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)) {
        //         stack.pop();
        //     }
        // }
        // return stack.size();
    }
}
