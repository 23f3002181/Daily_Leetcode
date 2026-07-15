class Solution {
    public int maxProduct(int[] nums) {
        int maxo = Integer.MIN_VALUE;
        int n = nums.length;
        int prefix = 1, suffix = 1;
        for (int i = 0; i < n; i++) {
            if (prefix == 0) {
                prefix = 1;
            }
            if (suffix == 0) {
                suffix = 1;
            }
            prefix *= nums[i];
            suffix *= nums[n - i - 1];
            maxo = Math.max(maxo, Math.max(suffix, prefix));
        }
        return maxo;
    }
}
