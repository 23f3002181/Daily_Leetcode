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
    List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        formResult(root, 0);
        return result;
    }

    private void formResult(TreeNode node, int level){
        if(node == null){
            return;
        }
        if(level == result.size()){
            result.add(node.val);
        }
        formResult(node.right, level + 1);
        formResult(node.left, level + 1);
    }
}
