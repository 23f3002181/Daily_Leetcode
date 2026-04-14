/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count = 0;

    public int pathSum(TreeNode root, int targetSum){
        if(root == null) return 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L,1);
        pathPrefixSum(root, targetSum, 0, map);
        return count;
    }

    public void pathPrefixSum(TreeNode root, int targetSum, long currSum, Map<Long, Integer> map){
        if(root == null) return;
        currSum += root.val;
        count += map.getOrDefault(currSum - targetSum, 0);
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        pathPrefixSum(root.left, targetSum, currSum, map);
        pathPrefixSum(root.right, targetSum, currSum, map);
        map.put(currSum, map.get(currSum) - 1);
    }
    

    // public int pathSum(TreeNode root, int targetSum) {
    //     if(root == null) return 0;
    //     pathSum(root, targetSum, 0);
    //     pathSum(root.left, targetSum);
    //     pathSum(root.right, targetSum);
    //     return count;
    // }

    // public void pathSum(TreeNode root, int targetSum, long currSum){
    //     if(root == null) return;
    //     currSum += root.val;
    //     if(currSum == targetSum){
    //         count++;
    //     }
    //     pathSum(root.left, targetSum, currSum);
    //     pathSum(root.right, targetSum, currSum);
    // }
}
