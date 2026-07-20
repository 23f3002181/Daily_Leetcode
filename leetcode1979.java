class Solution {
    public static int gcd(int a , int b){
        while(a > 0 && b > 0){
            if(a > b){
                a = a % b ;
            } else {
                b = b % a ;
            }
        }
        if(a == 0){
            return b ;
        } else{
            return a ;
        }
    }
    public int findGCD(int[] nums) {
        if(nums.length == 0) return 0 ;
        int min = Integer.MAX_VALUE ;
        int max = Integer.MIN_VALUE ;
        for(int i = 0 ; i < nums.length ; i++){
            min = Math.min(min, nums[i]) ;
            max = Math.max(max, nums[i]) ;
        }
        return gcd(max, min) ;
    }
}
