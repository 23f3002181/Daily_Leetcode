class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0 ;
        int l = 0 ;
        for(int r = 0 ; r < nums.length ; r++){
            map.put(nums[r], map.getOrDefault(nums[r],0) + 1);
            while(map.get(nums[r]) > k){
                map.put(nums[l], map.get(nums[l]) - 1);
                l++ ;
            }
            count = Math.max(count, r - l + 1);
        }
        return count;
    }
}
