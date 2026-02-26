class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Set<Integer> store = new HashSet<>();
        for(int num : nums){
            store.add(num);
        }
        int res = 0;
        for(int num : store){
            if(!store.contains(num - 1)){
                int streak = 1;
                while(store.contains(num + streak)){
                    streak++;
                }
                res = Math.max(res, streak);
            }
        }
        return res;

        // if(nums.length == 0){
        //     return 0;
        // }
        // Arrays.sort(nums);
        // int res = 0, curr = nums[0], streak = 0, i = 0 ;
        // while(i < nums.length){
        //     if(curr != nums[i]){
        //         curr = nums[i];
        //         streak = 0;
        //     }
        //     while(i < nums.length && curr == nums[i]){
        //         i++;
        //     }
        //     streak++;
        //     curr++;
        //     res = Math.max(res, streak);
        // }
        // return res; 

        // int res = 0;
        // Set<Integer> store = new HashSet<>();
        // for(int num : nums){
        //     store.add(num);
        // }
        // for(int num : nums){
        //     int streak = 0;
        //     while(store.contains(num)){
        //         streak++;
        //         num++;
        //     }
        //     res = Math.max(res, streak);
        // }
        // return res;
    }
}
