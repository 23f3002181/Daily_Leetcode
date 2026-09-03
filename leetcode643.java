class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double average = Integer.MIN_VALUE ;
        int sum = 0;
        int l = 0 ; 
        for(int r = 0 ; r < nums.length ; r++){
            sum += nums[r];
            if(r - l + 1 == k){
                average = Math.max(average, (double) sum / k) ;
                sum -= nums[l];
                l++ ;
            }
        }
        return average;
    }
}
