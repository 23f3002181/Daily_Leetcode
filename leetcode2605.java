class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int min_both = 10;
        for(int x : nums1){
            for(int y : nums2){
                if(x == y){
                    min_both = Math.min(x,min_both) ;
                }
            }
        }
        if(min_both != 10){
            return min_both ;
        }
        int min1 = 10 ;
        int min2 = 10 ;
        for(int num : nums1){
            min1 = Math.min(min1, num) ;
        }
        for(int num : nums2){
            min2 = Math.min(min2, num) ;
        }
        min_both = (Math.min(min1,min2) * 10) + Math.max(min1,min2) ;
        return min_both ;
    }
}
