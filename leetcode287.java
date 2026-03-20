class Solution {
    public int findDuplicate(int[] nums) {
        // Floyd's Cycle Detection
        int slow = 0 , fast = 0 ;
        while(true){
            slow = nums[slow] ; // slow = slow.next
            fast = nums[nums[fast]] ; // fast = fast.next.next
            if(slow == fast){ 
                break ; // cycle start point (may or may not be duplicate)
            }
        }
        int slow2 = 0 ;
        while(true){
            slow = nums[slow] ;
            slow2 = nums[slow2] ;
            if(slow == slow2){
                return slow ; // duplicate element
            }
        }
    }
}
