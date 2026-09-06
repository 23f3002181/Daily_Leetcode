class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] count = new int[1001];
        for(int n : nums1) count[n]++;
        int[] res = new int[Math.min(nums1.length,nums2.length)];
        int idx = 0;
        for(int n : nums2){
            if(count[n] > 0){
                res[idx++] = n;
                count[n]--;
            }
        }
        return java.util.Arrays.copyOfRange(res,0,idx);
    }
}
