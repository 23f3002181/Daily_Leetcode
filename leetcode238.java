class Solution {
    public int[] productExceptSelf(int[] nums) {
        int totalProduct = 1; int zeroCount = 0;
        for(int num : nums){
            if(num != 0){
                totalProduct *= num;
            } else{
                zeroCount++;
            }
        }
        if(zeroCount > 1){
            return new int[nums.length];
        }
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(zeroCount == 1){
                result[i] = (nums[i] == 0) ? totalProduct : 0;
            } else{
                result[i] = totalProduct / nums[i];
            }
        }
        return result;

        // int n = nums.length ;
        // int[] prefix = new int[n];
        // int[] suffix = new int[n];
        // int[] result = new int[n];
        // prefix[0] = 1;
        // suffix[n-1] = 1;
        // for(int i = 1; i < n; i++){
        //     prefix[i] = prefix[i-1] * nums[i-1];
        // }
        // for(int i = n-2; i >= 0; i--){
        //     suffix[i] = suffix[i+1] * nums[i+1];
        // }
        // for(int i = 0; i < n; i++){
        //     result[i] = prefix[i] * suffix[i];
        // }
        // return result;

        // int n = nums.length ;
        // int[] result = new int[n] ;
        // for(int i = 0; i < n; i++){
        //     int product = 1;
        //     for(int j = 0; j < n; j++){
        //         if(i != j){
        //             product *= nums[j];
        //         }
        //     }
        //     result[i] = product;
        // }
        // return result;
    }
}
