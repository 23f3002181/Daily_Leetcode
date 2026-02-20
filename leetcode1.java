class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> prevMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int diff = target - num;
            if(prevMap.containsKey(diff)){
                return new int[]{prevMap.get(diff),i};
            }
            prevMap.put(num,i);
        }
    return new int[0];
    
    //     for(int i = 0; i < nums.length; i++){
    //         for(int j = i+1; j < nums.length; j++){
    //             if(nums[i] + nums[j] == target){
    //                 return new int[]{i,j};
    //             }
    //         }
    //     }
    // return new int[0];

    //     int[][] A = new int[nums.length][2];
    //     for(int i = 0; i < nums.length; i++){
    //         A[i][0] = nums[i];
    //         A[i][1] = i;
    //     }
    //     Arrays.sort(A, Comparator.comparingInt(a -> a[0]));
    //     int i = 0;
    //     int j = nums.length - 1;
    //     while(i < j){
    //         int cur = A[i][0] + A[j][0];
    //         if(cur == target){
    //             return new int[]{Math.min(A[i][1],A[j][1]),Math.max(A[i][1],A[j][1])};
    //         } else if(cur < target){
    //             i++;
    //         } else{
    //             j--;
    //         }
    //     }
    // return new int[0];
    }
}
