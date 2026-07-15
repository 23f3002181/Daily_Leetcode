class Solution {
    public int pivotIndex(int[] nums) {
        int pivot = -1 ;
        int totalSum = 0 ;
        for(int num : nums){
            totalSum += num ;
        }
        int leftSum = 0 ;
        int rightSum = totalSum ;
        for(int i = 0 ; i < nums.length ; i++){
            rightSum -= nums[i] ;
            if(leftSum == rightSum){
                pivot = i ;
                break ;
            }
            leftSum += nums[i] ;
        }
        return pivot ;
    }
}
