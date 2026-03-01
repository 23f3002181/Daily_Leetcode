class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        int l = 0, r = height.length - 1;
        while(l < r){
            result = Math.max(result, Math.min(height[l],height[r])*(r - l));
            if(height[l] <= height[r]){
                l++;
            } else{
                r--;
            }
        }
        return result;

        // int result = 0;
        // for(int i = 0; i < height.length; i++){
        //     for(int j = i+1; j < height.length; j++){
        //         result = Math.max(result, Math.min(height[i],height[j])*(j-i));
        //     }
        // }
        // return result;
    }
}
