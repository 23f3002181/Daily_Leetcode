/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        serialize(root, result);
        return result.toString();
    }

    private void serialize(TreeNode node, StringBuilder result){
        if(node == null){
            result.append("null,");
            return;
        }
        result.append(node.val + ",");
        serialize(node.left, result);
        serialize(node.right, result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        int[] i = {0};
        return deserialize(values, i);
    }

    private TreeNode deserialize(String[] values, int[] i){
        if(values[i[0]].equals("null")){
            i[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(values[i[0]]));
        i[0]++;
        root.left = deserialize(values, i);
        root.right = deserialize(values, i);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
